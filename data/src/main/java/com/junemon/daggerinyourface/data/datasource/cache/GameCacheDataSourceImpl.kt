package com.junemon.daggerinyourface.data.datasource.cache

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.data.datasource.GameCacheDataSource
import com.junemon.daggerinyourface.cache.game.paging.GamePagingDbEntity
import com.junemon.daggerinyourface.cache.util.interfaces.GameDaoHelper
import com.junemon.daggerinyourface.cache.util.interfaces.GamePagingDaoHelper
import com.junemon.daggerinyourface.cache.util.dto.game.mapToData
import com.junemon.daggerinyourface.cache.util.dto.game.mapToDomain
import com.junemon.daggerinyourface.model.domain.game.GameData
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameCacheDataSourceImpl @Inject constructor(
    private val gameDao: GameDaoHelper,
    private val gamePagingDao: GamePagingDaoHelper
) : GameCacheDataSource {
    override suspend fun setCache(data: List<GameData>) {
        gameDao.insertGame(*data.mapToData().toTypedArray())
    }

    override suspend fun setPagingCache(data: List<GamePagingDbEntity>) {
        gamePagingDao.insertGame(*data.toTypedArray())
    }

    override fun getCache(): Flow<List<GameData>> {
        return gameDao.loadGame().map { it.mapToDomain() }
    }

    override fun getPagingCache(): DataSource.Factory<Int, GamePagingDbEntity> {
        return gamePagingDao.loadGame()
    }
}
