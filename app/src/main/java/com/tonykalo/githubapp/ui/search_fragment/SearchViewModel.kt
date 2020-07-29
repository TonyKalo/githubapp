package com.tonykalo.githubapp.ui.search_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonykalo.githubapp.core.data.Result.Error
import com.tonykalo.githubapp.core.data.Result.Success
import com.tonykalo.githubapp.ui.search_fragment.data.SearchRepo
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Item
import com.tonykalo.githubapp.utils.helpers.SingleLiveEvent
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel @Inject constructor(private val repo: SearchRepo) : ViewModel() {

    // pass -1 to close dialog
    private val _openSortDialog = MutableLiveData(-1)
    val openSortDialog: LiveData<Int> = _openSortDialog

    private val _showLoader = MutableLiveData(false)
    val showLoader: LiveData<Boolean> = _showLoader

    private val _githubRepos = MutableLiveData<List<Item>>()
    val githubRepos: LiveData<List<Item>> = _githubRepos

    private val _handleError = SingleLiveEvent<String>()
    val handleError = _handleError

    var debouncePeriod: Long = 300
    private var searchJob: Job? = null

    fun onSortClick() {
        _openSortDialog.value = repo.getSearchSortBy()
    }

    fun onDialogDismiss() {
        _openSortDialog.value = -1
    }

    fun onSelectedChoice(choice: Int) {
        repo.setSearchSortBy(choice)
    }

    fun onQueryTxtChange(query: String) {
        searchJob?.cancel()
        if (query.isNotEmpty()) {
            _showLoader.value = true
            searchJob = viewModelScope.launch {
                delay(debouncePeriod)
                repo.getGithubRepos(query).let {
                    _showLoader.value = false
                    when (it) {
                        is Success -> _githubRepos.value = it.data
                        is Error -> _handleError.value = it.exception.localizedMessage
                    }
                }
            }
        } else _showLoader.value = false
    }
}
