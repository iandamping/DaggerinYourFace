package com.junemon.daggerin.data.datasource.cache

import com.junemon.daggerin.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerin.data.db.publisher.mapToDomain
import com.junemon.daggerin.domain.model.PublishersData
import com.junemon.daggerin.domain.model.mapToDomain
import com.junemon.daggerin.util.interfaces.PublisherDaoHelper
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PublisherCacheDataSourceImpl @Inject constructor(private val publisherDao: PublisherDaoHelper) :
    PublisherCacheDataSource {
    override suspend fun setCache(data: List<PublishersData>) {
        publisherDao.insertPublisher(*data.mapToDomain().toTypedArray())
    }

    override fun getCache(): Flow<List<PublishersData>> {
        return publisherDao.loadPublisher().map { it.mapToDomain() }
    }
}
