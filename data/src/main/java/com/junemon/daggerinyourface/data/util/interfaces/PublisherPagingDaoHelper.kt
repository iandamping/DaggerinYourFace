package com.junemon.daggerinyourface.data.util.interfaces

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDbEntity

interface PublisherPagingDaoHelper {

    suspend fun insertPublisher(vararg data: PublisherPagingDbEntity)

    fun loadPublisher(): DataSource.Factory<Int, PublisherPagingDbEntity>
}
