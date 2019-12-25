package com.junemon.daggerin.data.datasource.cache

import com.junemon.daggerin.data.data.datasource.GameCacheDataSource
import com.junemon.daggerin.data.db.game.mapToData
import com.junemon.daggerin.data.db.game.mapToDomain
import com.junemon.daggerin.data.util.interfaces.GameDaoHelper
import com.junemon.daggerin.domain.model.GameData
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
