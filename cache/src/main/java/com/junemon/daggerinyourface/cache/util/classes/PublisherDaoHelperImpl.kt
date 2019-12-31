package com.junemon.daggerinyourface.cache.util.classes

import com.junemon.daggerinyourface.cache.util.interfaces.PublisherDaoHelper
import com.junemon.daggerinyourface.data.db.publisher.normal.PublisherDao
import com.junemon.daggerinyourface.data.db.publisher.normal.PublisherDbEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class PublisherDaoHelperImpl @Inject constructor(private val publisherDao: PublisherDao) :
    PublisherDaoHelper {

    override suspend fun insertPublisher(vararg data: PublisherDbEntity) {
        publisherDao.insertPublisher(*data)
    }

    override fun loadPublisher(): Flow<List<PublisherDbEntity>> {
        return publisherDao.loadPublisher()
    }
}
