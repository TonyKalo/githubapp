package com.tonykalo.githubapp.ui.user_detail_fragment.data

import com.tonykalo.githubapp.core.data.Result
import com.tonykalo.githubapp.core.data.Result.Error
import com.tonykalo.githubapp.core.data.Result.Success
import com.tonykalo.githubapp.ui.user_detail_fragment.data.network.UserDetailApiService
import com.tonykalo.githubapp.ui.user_detail_fragment.data.network.pojo.OwnerResponse
import java.lang.Exception
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserDetailRepoImpl @Inject constructor(private val api: UserDetailApiService) : UserDetailRepo {

    override suspend fun getOwnerData(url: String): Result<OwnerResponse> = withContext(Dispatchers.IO) {
        try {
            return@withContext Success(api.getUserDerails(url))
        } catch (e: Exception) {
            return@withContext Error(e)
        }
    }
}
