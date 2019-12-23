package com.junemon.daggerin.data.data.datasource

import com.junemon.daggerin.domain.model.PublishersData
import com.junemon.daggerin.domain.model.PublishersDetailData
import kotlinx.coroutines.flow.Flow

interface PublisherRemoteDataSource {
    suspend fun getPublisher(): List<PublishersData>

    suspend fun getDetailPublisher(publisherID: Int): PublishersDetailData
}

interface PublisherCacheDataSource {
    suspend fun setCache(data: List<PublishersData>)
    fun getCache(): Flow<List<PublishersData>>
}
