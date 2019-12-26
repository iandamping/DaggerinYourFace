package com.junemon.daggerinyourface.data.db.game

import com.junemon.daggerinyourface.data.db.GameDatabase
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GameDaoInjector @Inject constructor(private val database: GameDatabase) :
    GameDao {
    override suspend fun insertGame(vararg data: GameDbEntity) {
        database.gameDao().insertGame(*data)
    }

    override fun loadGame(): Flow<List<GameDbEntity>> {
        return database.gameDao().loadGame()
    }
}
