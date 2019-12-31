package com.junemon.daggerinyourface.data.datasource.cache

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDbEntity
import com.junemon.daggerinyourface.cache.util.interfaces.PublisherDaoHelper
import com.junemon.daggerinyourface.cache.util.interfaces.PublisherPagingDaoHelper
import com.junemon.daggerinyourface.data.util.dto.publisher.mapToData
import com.junemon.daggerinyourface.data.util.dto.publisher.mapToDomain
import com.junemon.daggerinyourface.model.domain.publisher.PublishersData
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PublisherCacheDataSourceImpl @Inject constructor(
    private val publisherDao: PublisherDaoHelper,
    private val publisherPagingDao: PublisherPagingDaoHelper
) : PublisherCacheDataSource {
    override suspend fun setCache(data: List<PublishersData>) {
        publisherDao.insertPublisher(*data.mapToData().toTypedArray())
    }

    override suspend fun setPagingCache(data: List<PublisherPagingDbEntity>) {
        publisherPagingDao.insertPublisher(*data.toTypedArray())
    }

    override fun getCache(): Flow<List<PublishersData>> {
        return publisherDao.loadPublisher().map { it.mapToDomain() }
    }

    override fun getPagingCache(): DataSource.Factory<Int, PublisherPagingDbEntity> {
        return publisherPagingDao.loadPublisher()
    }
}
