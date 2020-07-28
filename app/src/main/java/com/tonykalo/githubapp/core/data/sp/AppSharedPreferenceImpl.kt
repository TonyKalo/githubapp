package com.tonykalo.githubapp.core.data.sp

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppSharedPreferenceImpl @Inject constructor(private val sp: SharedPreferences) : AppSharedPreference {

    private val SORT_BY = "sort_by"

    override fun setSortBy(sortBy: Int) {
        sp.edit()?.putInt(SORT_BY, sortBy)?.apply()
    }

    override fun getSortBy(): Int {
        return sp.getInt(SORT_BY, 0)
    }
}
