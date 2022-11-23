package com.catnip.animemunity.presentation.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catnip.animemunity.data.firebase.model.User
import com.catnip.animemunity.data.repository.UserRepository

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class SplashViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {

    val currentUserLiveData = MutableLiveData<User?>()

    fun getCurrentUser() {
        currentUserLiveData.postValue(userRepository.getCurrentUser())
    }
}