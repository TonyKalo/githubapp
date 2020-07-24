package com.tonykalo.githubapp.ui.main_activity.di

import com.tonykalo.githubapp.ui.main_activity.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MainActivityModule::class, MainActivityBindModule::class])

interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<MainActivity>
}
