package com.tonykalo.githubapp.ui.user_detail_fragment

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
import com.tonykalo.githubapp.ui.user_detail_fragment.data.network.pojo.OwnerResponse
import com.tonykalo.githubapp.utils.extensions.toast
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mViewModel by viewModels<UserDetailViewModel> { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
        setObservers()
        setOnClickListeners()
//        initLoader()
    }

    private fun initLoader() {
        srlSearch.setOnRefreshListener { mViewModel.getData() }
    }

    private fun setOnClickListeners() {
        btnBack.setOnClickListener { findNavController().popBackStack() }
    }

    private fun setObservers() {
        mViewModel.ownerData.observe(viewLifecycleOwner, Observer { updateUI(it) })
        mViewModel.handleError.observe(viewLifecycleOwner, Observer { showSnackbar(it) })
        mViewModel.showLoader.observe(viewLifecycleOwner, Observer { })
    }
    private fun getArgs() {
        mViewModel.setOwnerUrl(arguments?.get("ownerUrl") as String)
    }

    private fun updateUI(ownerData: OwnerResponse) {
        requireContext().toast(ownerData.login)
    }

    private fun showSnackbar(msg: String) {
        Snackbar.make(requireActivity().findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show()
    }
}
