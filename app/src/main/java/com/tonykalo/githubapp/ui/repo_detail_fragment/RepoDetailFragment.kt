package com.tonykalo.githubapp.ui.repo_detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tonykalo.githubapp.R
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Item
import dagger.android.support.DaggerFragment
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
    }

    private fun setObservers() {
        mViewModel.githubRepos.observe(viewLifecycleOwner, Observer { updateUI(it) })
    }
    private fun getArgs() {
        mViewModel.setRepos(arguments?.get("item") as Item)
    }

    private fun updateUI(repo: Item) {
    }
}
