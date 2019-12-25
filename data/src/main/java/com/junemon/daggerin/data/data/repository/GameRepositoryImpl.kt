package com.junemon.daggerin.data.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.junemon.daggerin.data.data.datasource.GameCacheDataSource
import com.junemon.daggerin.data.data.datasource.GameRemoteDataSource
import com.junemon.daggerin.domain.model.GameData
import com.junemon.daggerin.domain.model.GamesDetailData
import com.junemon.daggerin.domain.model.ResultRemoteToConsume
import com.junemon.daggerin.domain.model.ResultToConsume
import com.junemon.daggerin.domain.repository.GameRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class GameRepositoryImpl @Inject constructor(
    private val cacheDataSource: GameCacheDataSource,
    private val remoteDataSource: GameRemoteDataSource
) : GameRepository {
    override fun getCache(): LiveData<ResultToConsume<List<GameData>>> {
        return liveData() {
            val disposables = emitSource(cacheDataSource.getCache().map {
                ResultToConsume.Loading(it)
            }.asLiveData())
            try {
                val data = remoteDataSource.getGame()
                disposables.dispose()
                check(data.isNotEmpty()) {
                    " empty data from service"
                }
                cacheDataSource.setCache(data)
                emitSource(cacheDataSource.getCache().map { ResultToConsume.Success(it) }.asLiveData())
            } catch (e: Exception) {
                emitSource(cacheDataSource.getCache().map {
                    ResultToConsume.Error(e.message!!, it)
                }.asLiveData())
            }
        }
    }

    override fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>> {
        return liveData {
            try {
                emit(ResultRemoteToConsume.loading())
                require(gameId != 0) {
                    "id passed from main is 0"
                }
                val data = remoteDataSource.getDetailGame(gameId)
                checkNotNull(data)
                emit(ResultRemoteToConsume.success(data))
            } catch (e: Exception) {
                emit(ResultRemoteToConsume.error(e.message!!))
            }
        }
    }
}
