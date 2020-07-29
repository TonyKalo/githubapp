package com.tonykalo.githubapp.ui.search_fragment.adapter

import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Item
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Owner

interface OnRepoClickListener {
    fun onUserClick(owner: Owner?)
    fun onRepoClick(repo: Item)
}
