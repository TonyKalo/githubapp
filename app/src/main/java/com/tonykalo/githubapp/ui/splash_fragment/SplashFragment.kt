package com.tonykalo.githubapp.ui.splash_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tonykalo.githubapp.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SplashFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mViewModel by viewModels<SplashViewModel> { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        mViewModel.navigateToMainScreen.observe(viewLifecycleOwner, Observer { navigateToMainScreen() })
    }

    private fun navigateToMainScreen() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSearchFragment())
    }
}
