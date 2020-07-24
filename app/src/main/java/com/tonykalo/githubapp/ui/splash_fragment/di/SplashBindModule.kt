package com.tonykalo.githubapp.ui.splash_fragment.di

import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.core.di.scopes.ViewModelKey
import com.tonykalo.githubapp.ui.splash_fragment.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashBindModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindViewModel(viewModel: SplashViewModel): ViewModel
}
