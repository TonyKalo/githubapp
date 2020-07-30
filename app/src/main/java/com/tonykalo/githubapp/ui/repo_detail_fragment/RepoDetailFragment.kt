package com.tonykalo.githubapp.ui.repo_detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tonykalo.githubapp.R
import com.tonykalo.githubapp.ui.repo_detail_fragment.data.network.pojo.RepoResponse
import com.tonykalo.githubapp.utils.extensions.log
import com.tonykalo.githubapp.utils.extensions.toast
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_user_detail.*

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
//        initLoader()
    }

//    private fun initLoader() {
//        srlSearch.setOnRefreshListener { mViewModel.getData() }
//    }

    private fun setOnClickListeners() {
        btnBack.setOnClickListener { findNavController().popBackStack() }
    }

    private fun setObservers() {
        mViewModel.repoData.observe(viewLifecycleOwner, Observer { updateUI(it) })
        mViewModel.handleError.observe(viewLifecycleOwner, Observer { showSnackbar(it) })
        mViewModel.showLoader.observe(viewLifecycleOwner, Observer { })
    }
    private fun getArgs() {
        mViewModel.setRepoUrl(arguments?.get("repoUrl") as String)
        arguments?.get("repoUrl")!!.log()
    }

    private fun updateUI(repoData: RepoResponse) {
        requireContext().toast(repoData.full_name)
    }

    private fun showSnackbar(msg: String) {
        Snackbar.make(requireActivity().findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show()
    }
}
