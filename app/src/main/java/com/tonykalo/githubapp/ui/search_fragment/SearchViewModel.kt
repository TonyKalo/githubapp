package com.tonykalo.githubapp.ui.search_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.ui.search_fragment.data.SearchRepo
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val repo: SearchRepo) : ViewModel() {

    // pass -1 to close dialog
    private val _openSortDialog = MutableLiveData(-1)
    val openSortDialog: LiveData<Int> = _openSortDialog

    fun onSortClick() {
        _openSortDialog.value = repo.getSearchSortBy()
    }

    fun onDialogDismiss() {
        _openSortDialog.value = -1
    }

    fun onSelectedChoice(choice: Int) {
        repo.setSearchSortBy(choice)
    }
}
