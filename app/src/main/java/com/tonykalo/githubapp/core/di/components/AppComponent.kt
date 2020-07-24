package com.tonykalo.githubapp.core.di.components

import com.tonykalo.githubapp.GithubApp
import com.tonykalo.githubapp.core.di.module.AppModule
import com.tonykalo.githubapp.core.di.module.DataModule
import com.tonykalo.githubapp.core.di.module.NetworkModule
import com.tonykalo.githubapp.core.di.module.SubcomponentsModule
import com.tonykalo.githubapp.core.di.module.ViewModelBindModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        DataModule::class,
        SubcomponentsModule::class,
        ViewModelBindModule::class
    ])
interface AppComponent : AndroidInjector<GithubApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: GithubApp): AndroidInjector<GithubApp>
    }
}
