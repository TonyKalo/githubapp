package com.tonykalo.githubapp.ui.search_fragment

import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.ui.search_fragment.data.SearchRepo
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val repo: SearchRepo) : ViewModel()
