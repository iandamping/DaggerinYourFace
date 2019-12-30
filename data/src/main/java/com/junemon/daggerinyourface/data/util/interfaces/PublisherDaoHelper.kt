package com.junemon.daggerinyourface.data.util.interfaces

import com.junemon.daggerinyourface.data.db.publisher.normal.PublisherDbEntity
import kotlinx.coroutines.flow.Flow

interface PublisherDaoHelper {

    suspend fun insertPublisher(vararg data: PublisherDbEntity)

    fun loadPublisher(): Flow<List<PublisherDbEntity>>
}
