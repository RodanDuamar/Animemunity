package com.catnip.animemunity.data.repository

import com.catnip.animemunity.base.BaseRepository
import com.catnip.animemunity.base.wrapper.Resource
import com.catnip.animemunity.data.firebase.ThreadDataSource
import com.catnip.animemunity.data.firebase.model.ThreadItem
import com.firebase.ui.database.FirebaseRecyclerOptions

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface ThreadRepository {
    suspend fun createThread(threadItem: ThreadItem): Resource<Boolean>
    fun getThread(): FirebaseRecyclerOptions<ThreadItem>
}

class ThreadRepositoryImpl(private val dataSource: ThreadDataSource) : BaseRepository(),
    ThreadRepository {
    override suspend fun createThread(threadItem: ThreadItem): Resource<Boolean> {
        return proceed { dataSource.createThread(threadItem) }
    }

    override fun getThread(): FirebaseRecyclerOptions<ThreadItem> {
        return dataSource.getThread()
    }
}