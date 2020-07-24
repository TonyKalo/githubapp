package com.tonykalo.githubapp.ui.user_detail_fragment.di

import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.core.di.scopes.ViewModelKey
import com.tonykalo.githubapp.ui.user_detail_fragment.UserDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserDetailBindModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun bindViewModel(viewModel: UserDetailViewModel): ViewModel
}
