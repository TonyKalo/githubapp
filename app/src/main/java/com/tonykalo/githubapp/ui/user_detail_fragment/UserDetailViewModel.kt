package com.tonykalo.githubapp.ui.user_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonykalo.githubapp.core.data.Result.Error
import com.tonykalo.githubapp.core.data.Result.Success
import com.tonykalo.githubapp.ui.user_detail_fragment.data.UserDetailRepo
import com.tonykalo.githubapp.ui.user_detail_fragment.data.network.pojo.OwnerResponse
import com.tonykalo.githubapp.utils.helpers.SingleLiveEvent
import javax.inject.Inject
import kotlinx.coroutines.launch

class UserDetailViewModel @Inject constructor(private val repo: UserDetailRepo) : ViewModel() {

    private val _ownerUrl = MutableLiveData<String>()

    private val _ownerData = MutableLiveData<OwnerResponse>()
    val ownerData: LiveData<OwnerResponse> = _ownerData

    private val _showLoader = MutableLiveData(false)
    val showLoader: LiveData<Boolean> = _showLoader

    private val _handleError = SingleLiveEvent<String>()
    val handleError = _handleError

    fun setOwnerUrl(ownerUrl: String) {
        _ownerUrl.value = ownerUrl
        getData()
    }

    fun getData() {
        _showLoader.value = true
        viewModelScope.launch {
            repo.getOwnerData(_ownerUrl.value!!).let {
                _showLoader.value = false
                when (it) {
                    is Success -> _ownerData.value = it.data
                    is Error -> _handleError.value = it.exception.localizedMessage
                }
            }
        }
    }
}
