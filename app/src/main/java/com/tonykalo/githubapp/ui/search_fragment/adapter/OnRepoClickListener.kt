package com.tonykalo.githubapp.ui.search_fragment.adapter

interface OnRepoClickListener {
    fun onUserClick(ownerUrl: String)
    fun onRepoClick(repoUrl: String)
}
