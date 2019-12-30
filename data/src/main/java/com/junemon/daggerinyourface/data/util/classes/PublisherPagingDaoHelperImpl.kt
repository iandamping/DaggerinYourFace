package com.junemon.daggerinyourface.data.util.classes

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDao
import com.junemon.daggerinyourface.data.util.interfaces.PublisherPagingDaoHelper
import com.junemon.daggerinyourface.model.data.database.publisher.PublisherPagingDbEntity
import javax.inject.Inject

class PublisherPagingDaoHelperImpl @Inject constructor(private val publisherPagingDao: PublisherPagingDao) : PublisherPagingDaoHelper {
    override suspend fun insertPublisher(vararg data: PublisherPagingDbEntity) {
        publisherPagingDao.insertPublisher(*data)
    }

    override fun loadPublisher(): DataSource.Factory<Int, PublisherPagingDbEntity> {
        return publisherPagingDao.loadPublisher()
    }
}
