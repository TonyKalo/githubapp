package com.tonykalo.githubapp.ui.search_fragment.data

import com.tonykalo.githubapp.core.data.Result
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Item

interface SearchRepo {

    fun getSearchSortBy(): Int
    fun setSearchSortBy(choice: Int)
    suspend fun getGithubRepos(query: String): Result<List<Item>>
}
