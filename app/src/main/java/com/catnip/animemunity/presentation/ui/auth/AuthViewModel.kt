package com.catnip.animemunity.presentation.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catnip.animemunity.base.wrapper.Resource
import com.catnip.animemunity.data.firebase.model.User
import com.catnip.animemunity.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class AuthViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {

    val loginResult = MutableLiveData<Resource<Pair<Boolean, User?>>>()

    fun authenticateGoogleLogin(token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loginResult.postValue(Resource.Loading())
            loginResult.postValue(userRepository.signInWithCredential(token))
        }
    }
}