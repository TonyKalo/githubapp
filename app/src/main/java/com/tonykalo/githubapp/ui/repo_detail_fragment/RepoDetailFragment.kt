package com.tonykalo.githubapp.ui.repo_detail_fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.tonykalo.githubapp.R
import com.tonykalo.githubapp.ui.repo_detail_fragment.data.network.pojo.RepoResponse
import com.tonykalo.githubapp.utils.extensions.formatServerDateToDate
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_repo_detail.*
import kotlinx.android.synthetic.main.row_user.*
import javax.inject.Inject


class RepoDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mViewModel by viewModels<RepoDetailViewModel> { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
        setObservers()
        setOnClickListeners()
        initLoader()
    }

    private fun initLoader() {
        srlRepoDetail.setOnRefreshListener { mViewModel.getData() }
    }

    private fun setOnClickListeners() {
        btnBack.setOnClickListener { findNavController().popBackStack() }
    }

    private fun setObservers() {
        mViewModel.repoData.observe(viewLifecycleOwner, Observer { updateUI(it) })
        mViewModel.handleError.observe(viewLifecycleOwner, Observer { showSnackbar(it) })
        mViewModel.showLoader.observe(viewLifecycleOwner, Observer { showSwipeLoader (it)})
    }
    private fun getArgs() {
        mViewModel.setRepoUrl(arguments?.get("repoUrl") as String)
    }

    private fun updateUI(repoData: RepoResponse) {
        repoData.apply {
            tvRepoName.text = name
            tvLanguage.text = language ?: "-"
            tvCreated.text = created_at.formatServerDateToDate()
            tvUpdated.text = updated_at.formatServerDateToDate()
            tvWatchers.text = watchers_count.toString()
            tvForks.text = forks_count.toString()
            tvIssues.text = open_issues_count.toString()
            Glide.with(requireContext()).asBitmap().load(owner.avatar_url).placeholder(R.drawable.github_logo).into(civOwner)
            tvOwner.text = owner.login
            btnExternal.setOnClickListener { openInExternalBrowser(html_url) }
            incOwner.setOnClickListener { findNavController().navigate(RepoDetailFragmentDirections.actionRepoDetailFragmentToUserDetailFragment(owner.url)) }
        }

    }

    private fun openInExternalBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    private fun showSnackbar(msg: String) {
        Snackbar.make(requireActivity().findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show()
    }

    private fun showSwipeLoader(show: Boolean) {
        srlRepoDetail.isRefreshing = show
    }
}
