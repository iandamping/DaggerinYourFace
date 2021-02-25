package com.junemon.daggerinyourface.core.data.repository

import com.junemon.daggerinyourface.core.data.datasource.cache.PublisherCacheDataSource
import com.junemon.daggerinyourface.core.data.datasource.remote.PublisherRemoteDataSource
import com.junemon.daggerinyourface.core.data.datasource.remote.helper.NetworkBoundResource
import com.junemon.daggerinyourface.core.data.datasource.remote.model.GamesResponse
import com.junemon.daggerinyourface.core.data.datasource.remote.model.PublishersResponse
import com.junemon.daggerinyourface.core.domain.model.ConsumeResult
import com.junemon.daggerinyourface.core.domain.model.DataHelper
import com.junemon.daggerinyourface.core.domain.model.PublishersDetailData
import com.junemon.daggerinyourface.core.domain.repository.PublisherRepository
import com.junemon.daggerinyourface.core.presentation.model.game.Game
import com.junemon.daggerinyourface.core.presentation.model.publisher.Publisher
import com.junemon.daggerinyourface.core.presentation.model.publisher.PublisherDetail
import com.junemon.daggerinyourface.core.util.dto.game.mapRemoteToDomain
import com.junemon.daggerinyourface.core.util.dto.game.mapToPresentation
import com.junemon.daggerinyourface.core.util.dto.publisher.mapRemoteToDomain
import com.junemon.daggerinyourface.core.util.dto.publisher.mapToPresentation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * Created by Ian Damping on 17,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
class PublisherRepositoryImpl @Inject constructor(
    private val remoteSource: PublisherRemoteDataSource,
    private val cacheSource: PublisherCacheDataSource
) : PublisherRepository {
    override fun getPublisher(): Flow<ConsumeResult<List<Publisher>>> {
        return object : NetworkBoundResource<List<Publisher>, List<PublishersResponse>>() {

            override fun loadFromDB(): Flow<List<Publisher>> {
                return cacheSource.getCache().map { it.mapToPresentation() }
            }

            override fun shouldFetch(data: List<Publisher>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<DataHelper<List<PublishersResponse>>> {
                return flowOf(remoteSource.getPublisher())
            }

            override suspend fun saveCallResult(data: List<PublishersResponse>) {
                cacheSource.setCache(data.mapRemoteToDomain())
            }
        }.asFlow()
    }

    override fun getDetailPublisher(publisherID: Int): Flow<ConsumeResult<PublisherDetail>> {
        return flow {
            when (val remoteResponse = remoteSource.getDetailPublisher(publisherID)) {
                is DataHelper.RemoteSourceValue -> {
                    emit(ConsumeResult.ConsumeData(remoteResponse.data.mapToPresentation()))
                }
                is DataHelper.RemoteSourceError -> {
                    emit(ConsumeResult.ErrorHappen(remoteResponse.exception.message))
                }
            }
        }
    }
}