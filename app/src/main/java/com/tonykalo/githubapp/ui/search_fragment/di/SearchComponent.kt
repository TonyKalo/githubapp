package com.tonykalo.githubapp.ui.search_fragment.di

import com.tonykalo.githubapp.ui.search_fragment.SearchFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [SearchModule::class, SearchBindModule::class])
interface SearchComponent : AndroidInjector<SearchFragment> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<SearchFragment>
}
