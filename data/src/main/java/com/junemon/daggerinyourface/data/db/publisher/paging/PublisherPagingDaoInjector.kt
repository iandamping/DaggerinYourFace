package com.junemon.daggerinyourface.data.db.publisher.paging

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.db.GameDatabase
import com.junemon.daggerinyourface.model.data.database.publisher.PublisherPagingDbEntity
import javax.inject.Inject

class PublisherPagingDaoInjector @Inject constructor(private val database: GameDatabase) : PublisherPagingDao {
    override suspend fun insertPublisher(vararg data: PublisherPagingDbEntity) {
        database.publisherPagingDao().insertPublisher(*data)
    }

    override fun loadPublisher(): DataSource.Factory<Int, PublisherPagingDbEntity> {
        return database.publisherPagingDao().loadPublisher()
    }
}
