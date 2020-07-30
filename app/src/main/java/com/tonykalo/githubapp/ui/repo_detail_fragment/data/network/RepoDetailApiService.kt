package com.tonykalo.githubapp.ui.repo_detail_fragment.data.network

import com.tonykalo.githubapp.ui.repo_detail_fragment.data.network.pojo.RepoResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface RepoDetailApiService {

    @GET
    suspend fun getRepoDetail(@Url url: String): RepoResponse
}
