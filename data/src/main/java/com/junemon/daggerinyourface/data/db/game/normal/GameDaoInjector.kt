package com.junemon.daggerinyourface.data.db.game.normal

import com.junemon.daggerinyourface.data.db.GameDatabase
import com.junemon.daggerinyourface.model.data.database.game.GameDbEntity
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
