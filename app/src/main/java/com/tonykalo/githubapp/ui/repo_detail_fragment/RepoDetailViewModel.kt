package com.tonykalo.githubapp.ui.repo_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Item
import javax.inject.Inject

class RepoDetailViewModel @Inject constructor() : ViewModel() {

    private val _githubRepos = MutableLiveData<Item>()
    val githubRepos: LiveData<Item> = _githubRepos

    fun setRepos(repo: Item) {
        _githubRepos.value = repo
    }
}
