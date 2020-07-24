package com.tonykalo.githubapp.ui.repo_detail_fragment.di

import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.core.di.scopes.ViewModelKey
import com.tonykalo.githubapp.ui.repo_detail_fragment.RepoDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RepoDetailBindModule {

    @Binds
    @IntoMap
    @ViewModelKey(RepoDetailViewModel::class)
    abstract fun bindViewModel(viewModel: RepoDetailViewModel): ViewModel
}
