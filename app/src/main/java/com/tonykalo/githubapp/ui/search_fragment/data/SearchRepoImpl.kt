package com.tonykalo.githubapp.ui.search_fragment.data

import com.tonykalo.githubapp.core.data.sp.AppSharedPreference
import com.tonykalo.githubapp.ui.search_fragment.data.network.SearchApiService
import javax.inject.Inject

class SearchRepoImpl @Inject constructor(private val sp: AppSharedPreference, private val api: SearchApiService) : SearchRepo {

    override fun getSearchSortBy(): Int {
        return sp.getSortBy()
    }
}
