package com.tonykalo.githubapp.ui.repo_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonykalo.githubapp.core.data.Result
import com.tonykalo.githubapp.ui.repo_detail_fragment.data.RepoDetailRepo
import com.tonykalo.githubapp.ui.repo_detail_fragment.data.network.pojo.RepoResponse
import com.tonykalo.githubapp.utils.helpers.SingleLiveEvent
import javax.inject.Inject
import kotlinx.coroutines.launch

class RepoDetailViewModel @Inject constructor(private val repo: RepoDetailRepo) : ViewModel() {

    private val _repoUrl = MutableLiveData<String>()

    private val _repoData = MutableLiveData<RepoResponse>()
    val repoData: LiveData<RepoResponse> = _repoData

    private val _showLoader = MutableLiveData(false)
    val showLoader: LiveData<Boolean> = _showLoader

    private val _handleError = SingleLiveEvent<String>()
    val handleError = _handleError

    fun setRepoUrl(repoUrl: String) {
        _repoUrl.value = repoUrl
        getData()
    }

    fun getData() {
        _showLoader.value = true
        viewModelScope.launch {
            repo.getRepoData(_repoUrl.value!!).let {
                _showLoader.value = false
                when (it) {
                    is Result.Success -> _repoData.value = it.data
                    is Result.Error -> _handleError.value = it.exception.localizedMessage
                }
            }
        }
    }
}
