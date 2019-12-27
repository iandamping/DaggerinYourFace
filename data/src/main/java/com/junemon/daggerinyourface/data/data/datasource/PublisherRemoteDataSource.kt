package com.junemon.daggerinyourface.data.data.datasource

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.datasource.model.PublisherDetailEntity
import com.junemon.daggerinyourface.data.datasource.model.PublishersEntity
import com.junemon.daggerinyourface.data.datasource.model.PublishersPagingEntity
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDbEntity
import com.junemon.daggerinyourface.domain.model.PublishersData
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
