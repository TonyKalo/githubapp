package com.tonykalo.githubapp.ui.user_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Owner
import com.tonykalo.githubapp.utils.extensions.log
import javax.inject.Inject

class UserDetailViewModel @Inject constructor() : ViewModel() {

    private val _owner = MutableLiveData<Owner>()
    val owner: LiveData<Owner> = _owner

    fun setOwner(owner: Owner) {
        _owner.value = owner
        owner.log()
    }
}
