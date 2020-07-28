package com.tonykalo.githubapp.ui.search_fragment.di

import com.tonykalo.githubapp.ui.search_fragment.data.SearchRepo
import com.tonykalo.githubapp.ui.search_fragment.data.SearchRepoImpl
import com.tonykalo.githubapp.ui.search_fragment.data.network.SearchApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object SearchModule {
    @Provides
    fun provideSearchRepo(searchRepoImpl: SearchRepoImpl): SearchRepo {
        return searchRepoImpl
    }

    @Provides
    @JvmSuppressWildcards
    fun provideSearchApiService(retrofit: Retrofit): SearchApiService {
        return retrofit.create(SearchApiService::class.java)
    }
}
