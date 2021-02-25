package com.junemon.daggerinyourface.core.data.repository

import com.junemon.daggerinyourface.core.data.datasource.cache.GameCacheDataSource
import com.junemon.daggerinyourface.core.data.datasource.remote.GameRemoteDataSource
import com.junemon.daggerinyourface.core.data.datasource.remote.helper.NetworkBoundResource
import com.junemon.daggerinyourface.core.data.datasource.remote.model.GamesResponse
import com.junemon.daggerinyourface.core.domain.model.ConsumeResult
import com.junemon.daggerinyourface.core.domain.model.DataHelper
import com.junemon.daggerinyourface.core.domain.repository.GameRepository
import com.junemon.daggerinyourface.core.presentation.model.game.Game
import com.junemon.daggerinyourface.core.presentation.model.game.GamesDetail
import com.junemon.daggerinyourface.core.util.dto.game.mapRemoteToDomain
import com.junemon.daggerinyourface.core.util.dto.game.mapToPresentation
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
class GameRepositoryImpl @Inject constructor(
    private val remoteSource: GameRemoteDataSource,
    private val cacheSource: GameCacheDataSource
) : GameRepository {
    override fun getGame(): Flow<ConsumeResult<List<Game>>> {
        return object : NetworkBoundResource<List<Game>, List<GamesResponse>>() {

            override fun loadFromDB(): Flow<List<Game>> {
                return cacheSource.getCache().map { it.mapToPresentation() }
            }

            override fun shouldFetch(data: List<Game>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<DataHelper<List<GamesResponse>>> {
                return flowOf(remoteSource.getGame())
            }

            override suspend fun saveCallResult(data: List<GamesResponse>) {
                cacheSource.setCache(data.mapRemoteToDomain())
            }
        }.asFlow()
    }

    override fun getDetailGame(gameId: Int): Flow<ConsumeResult<GamesDetail>> {
        return flow {
            when (val remoteResponse = remoteSource.getDetailGame(gameId)) {
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