package com.tonykalo.githubapp.core.di.module

import com.tonykalo.githubapp.ui.main_activity.MainActivity
import com.tonykalo.githubapp.ui.main_activity.di.MainActivityComponent
import com.tonykalo.githubapp.ui.repo_detail_fragment.RepoDetailFragment
import com.tonykalo.githubapp.ui.repo_detail_fragment.di.RepoDetailComponent
import com.tonykalo.githubapp.ui.search_fragment.SearchFragment
import com.tonykalo.githubapp.ui.search_fragment.di.SearchComponent
import com.tonykalo.githubapp.ui.splash_fragment.SplashFragment
import com.tonykalo.githubapp.ui.splash_fragment.di.SplashComponent
import com.tonykalo.githubapp.ui.user_detail_fragment.UserDetailFragment
import com.tonykalo.githubapp.ui.user_detail_fragment.di.UserDetailComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        MainActivityComponent::class,
        SearchComponent::class,
        RepoDetailComponent::class,
        UserDetailComponent::class,
        SplashComponent::class
    ]
)
abstract class SubcomponentsModule {


    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindMainActivityInjectorFactory(factory: MainActivityComponent.Factory?): AndroidInjector.Factory<*>?

    @Binds
    @IntoMap
    @ClassKey(SearchFragment::class)
    abstract fun bindSearchInjectorFactory(factory: SearchComponent.Factory?): AndroidInjector.Factory<*>?

    @Binds
    @IntoMap
    @ClassKey(RepoDetailFragment::class)
    abstract fun bindRepoDetailInjectorFactory(factory: RepoDetailComponent.Factory?): AndroidInjector.Factory<*>?

    @Binds
    @IntoMap
    @ClassKey(UserDetailFragment::class)
    abstract fun bindUserDetailInjectorFactory(factory: UserDetailComponent.Factory?): AndroidInjector.Factory<*>?

    @Binds
    @IntoMap
    @ClassKey(SplashFragment::class)
    abstract fun bindSplashFragmentInjectorFactory(factory: SplashComponent.Factory?): AndroidInjector.Factory<*>?


}
