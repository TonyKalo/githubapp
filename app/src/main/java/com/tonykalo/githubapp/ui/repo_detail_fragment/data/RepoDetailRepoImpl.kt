package com.tonykalo.githubapp.ui.repo_detail_fragment.data

import com.tonykalo.githubapp.core.data.Result
import com.tonykalo.githubapp.core.data.Result.Error
import com.tonykalo.githubapp.core.data.Result.Success
import com.tonykalo.githubapp.ui.repo_detail_fragment.data.network.RepoDetailApiService
import com.tonykalo.githubapp.ui.repo_detail_fragment.data.network.pojo.RepoResponse
import java.lang.Exception
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepoDetailRepoImpl @Inject constructor(private val api: RepoDetailApiService) : RepoDetailRepo {
    override suspend fun getRepoData(url: String): Result<RepoResponse> = withContext(Dispatchers.IO) {
        try {
            return@withContext Success(api.getRepoDetail(url))
        } catch (e: Exception) {
            return@withContext Error(e)
        }
    }
}
