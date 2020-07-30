package com.tonykalo.githubapp.ui.user_detail_fragment.data.network

import com.tonykalo.githubapp.ui.user_detail_fragment.data.network.pojo.OwnerResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface UserDetailApiService {

    @GET
    suspend fun getUserDerails(@Url url: String): OwnerResponse
}
