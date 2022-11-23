package com.catnip.animemunity.presentation.ui.thread

import androidx.lifecycle.ViewModel
import com.catnip.animemunity.data.repository.ThreadRepository

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class ThreadViewModel(private val repository: ThreadRepository) : ViewModel() {
    fun getThreadStreamData() = repository.getThread()
}