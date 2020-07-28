package com.tonykalo.githubapp.ui.search_fragment.data

interface SearchRepo {

    fun getSearchSortBy(): Int
    fun setSearchSortBy(choice: Int)
}
