package com.tonykalo.githubapp.ui.user_detail_fragment.di

import com.tonykalo.githubapp.ui.user_detail_fragment.UserDetailFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [UserDetailModule::class, UserDetailBindModule::class])
interface UserDetailComponent : AndroidInjector<UserDetailFragment> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<UserDetailFragment>
}
