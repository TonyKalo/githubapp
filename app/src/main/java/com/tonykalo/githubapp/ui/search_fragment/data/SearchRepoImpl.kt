package com.tonykalo.githubapp.ui.search_fragment.data

import com.tonykalo.githubapp.core.data.Result
import com.tonykalo.githubapp.core.data.Result.Error
import com.tonykalo.githubapp.core.data.Result.Success
import com.tonykalo.githubapp.core.data.sp.AppSharedPreference
import com.tonykalo.githubapp.ui.search_fragment.data.network.SearchApiService
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Item
import com.tonykalo.githubapp.utils.SORT_FORKS
import com.tonykalo.githubapp.utils.SORT_STARS
import com.tonykalo.githubapp.utils.SORT_UPDATED
import java.lang.Exception
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchRepoImpl @Inject constructor(private val sp: AppSharedPreference, private val api: SearchApiService) : SearchRepo {

    override fun getSearchSortBy(): Int {
        return sp.getSortBy()
    }

    override fun setSearchSortBy(choice: Int) {
        sp.setSortBy(choice)
    }

    override suspend fun getGithubRepos(query: String): Result<List<Item>> = withContext(Dispatchers.IO) {
        try {
            when (sp.getSortBy()) {
                SORT_STARS -> return@withContext Success(api.searchRepos(query, "stars", "desc").items)
                SORT_FORKS -> return@withContext Success(api.searchRepos(query, "forks", "desc").items)
                SORT_UPDATED -> return@withContext Success(api.searchRepos(query, "updated", "desc").items)
                else -> return@withContext Error(Exception("Something went wrong"))
            }
        } catch (e: Exception) {
            return@withContext Error(e)
        }
    }
}
