package com.junemon.daggerinyourface.data.util.classes

import com.junemon.daggerinyourface.data.db.publisher.normal.PublisherDao
import com.junemon.daggerinyourface.data.db.publisher.normal.PublisherDbEntity
import com.junemon.daggerinyourface.data.util.interfaces.PublisherDaoHelper
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
