package com.junemon.daggerinyourface.data.data.datasource

import com.junemon.daggerinyourface.domain.model.PublishersData
import com.junemon.daggerinyourface.domain.model.PublishersDetailData
import kotlinx.coroutines.flow.Flow

interface PublisherRemoteDataSource {
    suspend fun getPublisher(): List<PublishersData>

    suspend fun getDetailPublisher(publisherID: Int): PublishersDetailData
}

interface PublisherCacheDataSource {
    suspend fun setCache(data: List<PublishersData>)
    fun getCache(): Flow<List<PublishersData>>
}
