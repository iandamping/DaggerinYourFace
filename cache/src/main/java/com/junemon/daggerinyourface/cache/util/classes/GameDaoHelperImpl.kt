package com.junemon.daggerinyourface.cache.util.classes

import com.junemon.daggerinyourface.cache.util.interfaces.GameDaoHelper
import com.junemon.daggerinyourface.cache.game.normal.GameDao
import com.junemon.daggerinyourface.cache.game.normal.GameDbEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GameDaoHelperImpl @Inject constructor(private val gameDao: GameDao) :
    GameDaoHelper {

    override suspend fun insertGame(vararg data: GameDbEntity) {
        gameDao.insertGame(*data)
    }

    override fun loadGame(): Flow<List<GameDbEntity>> {
        return gameDao.loadGame()
    }
}
