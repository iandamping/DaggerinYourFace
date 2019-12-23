package com.junemon.daggerin.db.publisher

import com.junemon.daggerin.db.GameDatabase
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class PublisherDaoInjector @Inject constructor(private val database: GameDatabase) : PublisherDao {
    override suspend fun insertPublisher(vararg data: PublisherDbEntity) {
        database.publisherDao().insertPublisher(*data)
    }

    override fun loadPublisher(): Flow<List<PublisherDbEntity>> {
        return database.publisherDao().loadPublisher()
    }
}
