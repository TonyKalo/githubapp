package com.tonykalo.githubapp.ui.main_activity.di

import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.core.di.scopes.ViewModelKey
import com.tonykalo.githubapp.ui.main_activity.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityBindModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}
