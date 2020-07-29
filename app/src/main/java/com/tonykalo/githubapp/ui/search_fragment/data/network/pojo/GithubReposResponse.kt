package com.tonykalo.githubapp.ui.search_fragment.data.network.pojo

data class GithubReposResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)
