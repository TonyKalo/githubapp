package com.tonykalo.githubapp.ui.splash_fragment.di

import com.tonykalo.githubapp.ui.splash_fragment.SplashFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [SplashModule::class, SplashBindModule::class])
interface SplashComponent : AndroidInjector<SplashFragment> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<SplashFragment>
}
