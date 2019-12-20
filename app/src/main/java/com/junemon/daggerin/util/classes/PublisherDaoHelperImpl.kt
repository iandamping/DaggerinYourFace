package com.junemon.daggerin.util.classes

import com.junemon.daggerin.db.publisher.PublisherDao
import com.junemon.daggerin.db.publisher.PublisherDbEntity
import com.junemon.daggerin.util.interfaces.PublisherDaoHelper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PublisherDaoHelperImpl @Inject constructor(private val publisherDao: PublisherDao) :
    PublisherDaoHelper {

    override suspend fun insertPublisher(vararg data: PublisherDbEntity) {
        publisherDao.insertPublisher(*data)
    }

    override fun loadPublisher(): Flow<List<PublisherDbEntity>> {
        return publisherDao.loadPublisher()
    }
}