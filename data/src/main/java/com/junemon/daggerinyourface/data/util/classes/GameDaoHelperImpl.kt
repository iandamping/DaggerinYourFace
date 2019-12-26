package com.junemon.daggerinyourface.data.util.classes

import com.junemon.daggerinyourface.data.db.game.GameDao
import com.junemon.daggerinyourface.data.db.game.GameDbEntity
import com.junemon.daggerinyourface.data.util.interfaces.GameDaoHelper
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