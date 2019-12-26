package com.junemon.daggerinyourface.data.datasource.cache

import com.junemon.daggerinyourface.data.data.datasource.GameCacheDataSource
import com.junemon.daggerinyourface.data.db.game.mapToData
import com.junemon.daggerinyourface.data.db.game.mapToDomain
import com.junemon.daggerinyourface.data.util.interfaces.GameDaoHelper
import com.junemon.daggerinyourface.domain.model.GameData
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameCacheDataSourceImpl @Inject constructor(private val gameDao: GameDaoHelper) :GameCacheDataSource {
    override suspend fun setCache(data: List<GameData>) {
        gameDao.insertGame(*data.mapToData().toTypedArray())
    }

    override fun getCache(): Flow<List<GameData>> {
        return gameDao.loadGame().map { it.mapToDomain() }
    }
}