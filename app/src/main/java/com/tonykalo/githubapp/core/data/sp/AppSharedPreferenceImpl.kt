package com.tonykalo.githubapp.core.data.sp

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppSharedPreferenceImpl @Inject constructor(private val sp: SharedPreferences) : AppSharedPreference {

}
