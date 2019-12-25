package com.junemon.daggerin.data.util.classes

import com.junemon.daggerin.data.db.publisher.PublisherDao
import com.junemon.daggerin.data.db.publisher.PublisherDbEntity
import com.junemon.daggerin.data.util.interfaces.PublisherDaoHelper
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
