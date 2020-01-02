package com.junemon.daggerinyourface.cache.util.interfaces

import androidx.paging.DataSource
import com.junemon.daggerinyourface.cache.publisher.paging.PublisherPagingDbEntity

interface PublisherPagingDaoHelper {

    suspend fun insertPublisher(vararg data: PublisherPagingDbEntity)

    fun loadPublisher(): DataSource.Factory<Int, PublisherPagingDbEntity>
}
