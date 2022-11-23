package com.catnip.animemunity.presentation.ui.webdetail

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catnip.animemunity.base.wrapper.Resource

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class WebDetailViewModel(private val intentData: Bundle) : ViewModel() {

    val urlResult = MutableLiveData<Resource<String>>()

    fun loadUrl() {
        urlResult.postValue(Resource.Loading())
        val url = intentData.getString(WebDetailActivity.EXTRAS_ANIME_EPS_URL)
        url?.let {
            urlResult.postValue(Resource.Success(it))
        } ?: urlResult.postValue(Resource.Empty())
    }
}