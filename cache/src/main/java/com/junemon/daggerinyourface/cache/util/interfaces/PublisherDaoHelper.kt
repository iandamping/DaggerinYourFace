package com.junemon.daggerinyourface.cache.util.interfaces

import com.junemon.daggerinyourface.cache.publisher.normal.PublisherDbEntity
import kotlinx.coroutines.flow.Flow

interface PublisherDaoHelper {

    suspend fun insertPublisher(vararg data: PublisherDbEntity)

    fun loadPublisher(): Flow<List<PublisherDbEntity>>
}
