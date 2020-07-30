package com.tonykalo.githubapp.ui.user_detail_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.utils.extensions.log
import javax.inject.Inject

class UserDetailViewModel @Inject constructor() : ViewModel() {

    private val _ownerUrl = MutableLiveData<String>()

    fun setOwnerUrl(ownerUrl: String) {
        _ownerUrl.value = ownerUrl
        getData()
    }

    fun getData() {
        _ownerUrl.value?.log()
    }
}
