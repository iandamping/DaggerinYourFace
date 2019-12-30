package com.junemon.daggerinyourface.data.data.datasource

import androidx.paging.DataSource
import com.junemon.daggerinyourface.model.data.database.publisher.PublisherPagingDbEntity
import com.junemon.daggerinyourface.model.data.remote.publisher.PublisherDetailEntity
import com.junemon.daggerinyourface.model.data.remote.publisher.PublishersEntity
import com.junemon.daggerinyourface.model.data.remote.publisher.PublishersPagingEntity
import com.junemon.daggerinyourface.model.domain.publisher.PublishersData
import kotlinx.coroutines.flow.Flow

interface PublisherRemoteDataSource {
    suspend fun getPublisher(): List<PublishersEntity>

    suspend fun getDetailPublisher(publisherID: Int): PublisherDetailEntity

    suspend fun getPaginationPublisher(page: Int): List<PublishersPagingEntity>
}

interface PublisherCacheDataSource {
    suspend fun setCache(data: List<PublishersData>)
    suspend fun setPagingCache(data: List<PublisherPagingDbEntity>)
    fun getCache(): Flow<List<PublishersData>>
    fun getPagingCache(): DataSource.Factory<Int, PublisherPagingDbEntity>
}
