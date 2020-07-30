package com.tonykalo.githubapp.ui.user_detail_fragment.data

import com.tonykalo.githubapp.core.data.Result
import com.tonykalo.githubapp.ui.user_detail_fragment.data.network.pojo.OwnerResponse

interface UserDetailRepo {

    suspend fun getOwnerData(url: String): Result<OwnerResponse>
}
