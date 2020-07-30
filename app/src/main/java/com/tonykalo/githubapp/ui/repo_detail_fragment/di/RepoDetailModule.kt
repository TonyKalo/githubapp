package com.tonykalo.githubapp.ui.repo_detail_fragment.di

import com.tonykalo.githubapp.ui.repo_detail_fragment.data.RepoDetailRepo
import com.tonykalo.githubapp.ui.repo_detail_fragment.data.RepoDetailRepoImpl
import com.tonykalo.githubapp.ui.repo_detail_fragment.data.network.RepoDetailApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object RepoDetailModule {
    @Provides
    fun provideRepoDetailRepo(repoDetailRepoImpl: RepoDetailRepoImpl): RepoDetailRepo {
        return repoDetailRepoImpl
    }

    @Provides
    @JvmSuppressWildcards
    fun provideRepoDetailApiService(retrofit: Retrofit): RepoDetailApiService {
        return retrofit.create(RepoDetailApiService::class.java)
    }
}
