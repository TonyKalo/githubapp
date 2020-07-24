package com.tonykalo.githubapp.ui.splash_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonykalo.githubapp.utils.helpers.SingleLiveEvent
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel @Inject constructor() : ViewModel() {

    val navigateToMainScreen = SingleLiveEvent<Boolean>()

    init {
        viewModelScope.launch {
            delay(3000)
            navigateToMainScreen.call()
        }
    }
}
