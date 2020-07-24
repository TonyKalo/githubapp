package com.tonykalo.githubapp.ui.repo_detail_fragment.di

import com.tonykalo.githubapp.ui.repo_detail_fragment.RepoDetailFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [RepoDetailModule::class, RepoDetailBindModule::class])
interface RepoDetailComponent : AndroidInjector<RepoDetailFragment> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<RepoDetailFragment>
}
