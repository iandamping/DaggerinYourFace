package com.junemon.daggerin.util.classes

import com.junemon.daggerin.db.game.GameDao
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameDaoHelperImpl @Inject constructor(private val gameDao: GameDao) : GameDaoHelper {

    override suspend fun insertGame(vararg  data:GameDbEntity) {
        gameDao.insertGame(*data)
    }

    override fun loadGame(): Flow<List<GameDbEntity>> {
        return gameDao.loadGame()
    }
}