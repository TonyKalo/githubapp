package com.tonykalo.githubapp.ui.search_fragment.di

import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.core.di.scopes.ViewModelKey
import com.tonykalo.githubapp.ui.search_fragment.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SearchBindModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindViewModel(viewModel: SearchViewModel): ViewModel
}
