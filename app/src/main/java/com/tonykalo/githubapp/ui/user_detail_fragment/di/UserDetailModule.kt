package com.tonykalo.githubapp.ui.user_detail_fragment.di

import com.tonykalo.githubapp.ui.user_detail_fragment.data.UserDetailRepo
import com.tonykalo.githubapp.ui.user_detail_fragment.data.UserDetailRepoImpl
import com.tonykalo.githubapp.ui.user_detail_fragment.data.network.UserDetailApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object UserDetailModule {
    @Provides
    fun provideUserDetailRepo(userDetailRepoImpl: UserDetailRepoImpl): UserDetailRepo {
        return userDetailRepoImpl
    }

    @Provides
    @JvmSuppressWildcards
    fun provideUserDetailApiService(retrofit: Retrofit): UserDetailApiService {
        return retrofit.create(UserDetailApiService::class.java)
    }
}
