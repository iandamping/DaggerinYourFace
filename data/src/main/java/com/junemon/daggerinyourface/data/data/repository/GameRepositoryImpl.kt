package com.junemon.daggerinyourface.data.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.junemon.daggerinyourface.data.data.datasource.GameCacheDataSource
import com.junemon.daggerinyourface.data.data.datasource.GameRemoteDataSource
import com.junemon.daggerinyourface.data.data.repository.paginationfactory.GamePaginationRepositoryFactory
import com.junemon.daggerinyourface.data.util.dto.game.mapToDomain
import com.junemon.daggerinyourface.domain.repository.GameRepository
import com.junemon.daggerinyourface.model.data.dto.game.mapToDomain
import com.junemon.daggerinyourface.model.domain.ResultRemoteToConsume
import com.junemon.daggerinyourface.model.domain.ResultToConsume
import com.junemon.daggerinyourface.model.domain.game.GameData
import com.junemon.daggerinyourface.model.domain.game.GamePagingData
import com.junemon.daggerinyourface.model.domain.game.GamesDetailData
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
                cacheDataSource.setCache(remoteDataSource.getGame().mapToDomain())
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
                emit(ResultRemoteToConsume.success(data.mapToDomain()))
            } catch (e: Exception) {
                emit(ResultRemoteToConsume.error(e.message!!))
            }
        }
    }

    override fun getPaginationCache(): LiveData<PagedList<GamePagingData>> {
        val dataSourceFactory = GamePaginationRepositoryFactory(cacheDataSource, remoteDataSource).map { it.mapToDomain() }
        return LivePagedListBuilder(dataSourceFactory, GamePaginationRepositoryFactory.pagedListConfig()).build()
    }
}
