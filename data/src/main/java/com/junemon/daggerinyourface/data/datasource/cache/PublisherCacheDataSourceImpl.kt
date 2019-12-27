package com.junemon.daggerinyourface.data.datasource.cache

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerinyourface.data.db.publisher.normal.mapToData
import com.junemon.daggerinyourface.data.db.publisher.normal.mapToDomain
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDbEntity
import com.junemon.daggerinyourface.data.util.interfaces.PublisherDaoHelper
import com.junemon.daggerinyourface.data.util.interfaces.PublisherPagingDaoHelper
import com.junemon.daggerinyourface.domain.model.PublishersData
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
