package com.junemon.daggerinyourface.data.datasource.cache

import com.junemon.daggerinyourface.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerinyourface.data.db.publisher.mapToData
import com.junemon.daggerinyourface.data.db.publisher.mapToDomain
import com.junemon.daggerinyourface.data.util.interfaces.PublisherDaoHelper
import com.junemon.daggerinyourface.domain.model.PublishersData
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PublisherCacheDataSourceImpl @Inject constructor(private val publisherDao: PublisherDaoHelper) :PublisherCacheDataSource {
    override suspend fun setCache(data: List<PublishersData>) {
        publisherDao.insertPublisher(*data.mapToData().toTypedArray())
    }

    override fun getCache(): Flow<List<PublishersData>> {
        return publisherDao.loadPublisher().map { it.mapToDomain() }
    }
}
