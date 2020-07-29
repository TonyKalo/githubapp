package com.tonykalo.githubapp.ui.search_fragment.data.network

import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.GithubReposResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {

    @GET("/search/repositories")
    suspend fun searchRepos(@Query("q") query: String, @Query("sort") sort: String, @Query("order") order: String): GithubReposResponse
}
