package com.junemon.daggerinyourface.cache.util.classes

import androidx.paging.DataSource
import com.junemon.daggerinyourface.cache.util.interfaces.PublisherPagingDaoHelper
import com.junemon.daggerinyourface.cache.publisher.paging.PublisherPagingDao
import com.junemon.daggerinyourface.cache.publisher.paging.PublisherPagingDbEntity
import javax.inject.Inject

class PublisherPagingDaoHelperImpl @Inject constructor(private val publisherPagingDao: PublisherPagingDao) :
    PublisherPagingDaoHelper {
    override suspend fun insertPublisher(vararg data: PublisherPagingDbEntity) {
        publisherPagingDao.insertPublisher(*data)
    }

    override fun loadPublisher(): DataSource.Factory<Int, PublisherPagingDbEntity> {
        return publisherPagingDao.loadPublisher()
    }
}
