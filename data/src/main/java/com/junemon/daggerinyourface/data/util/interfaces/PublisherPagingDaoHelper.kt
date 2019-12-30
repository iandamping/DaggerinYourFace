package com.junemon.daggerinyourface.data.util.interfaces

import androidx.paging.DataSource
import com.junemon.daggerinyourface.model.data.database.publisher.PublisherPagingDbEntity

interface PublisherPagingDaoHelper {

    suspend fun insertPublisher(vararg data: PublisherPagingDbEntity)

    fun loadPublisher(): DataSource.Factory<Int, PublisherPagingDbEntity>
}
