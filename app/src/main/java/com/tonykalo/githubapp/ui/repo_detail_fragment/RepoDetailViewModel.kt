package com.tonykalo.githubapp.ui.repo_detail_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.utils.extensions.log
import javax.inject.Inject

class RepoDetailViewModel @Inject constructor() : ViewModel() {

    private val _repoUrl = MutableLiveData<String>()

    fun setRepoUrl(repoUrl: String) {
        _repoUrl.value = repoUrl
        getData()
    }

    fun getData() {
        _repoUrl.value?.log()
    }
}
