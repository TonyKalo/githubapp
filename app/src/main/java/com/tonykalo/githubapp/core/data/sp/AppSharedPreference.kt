package com.tonykalo.githubapp.core.data.sp

interface AppSharedPreference {

    fun setSortBy(sortBy: Int)
    fun getSortBy(): Int
}
