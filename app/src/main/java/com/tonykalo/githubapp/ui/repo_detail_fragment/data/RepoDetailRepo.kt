package com.tonykalo.githubapp.ui.repo_detail_fragment.data

import com.tonykalo.githubapp.core.data.Result
import com.tonykalo.githubapp.ui.repo_detail_fragment.data.network.pojo.RepoResponse

interface RepoDetailRepo {

    suspend fun getRepoData(url: String): Result<RepoResponse>
}
