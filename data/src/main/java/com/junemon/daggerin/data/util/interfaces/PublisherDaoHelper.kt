package com.junemon.daggerin.data.util.interfaces

import com.junemon.daggerin.data.db.publisher.PublisherDbEntity
import kotlinx.coroutines.flow.Flow

interface PublisherDaoHelper {

    suspend fun insertPublisher(vararg data: PublisherDbEntity)

    fun loadPublisher(): Flow<List<PublisherDbEntity>>
}
