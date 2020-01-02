package com.junemon.daggerinyourface.cache.game.paging

import androidx.paging.DataSource
import com.junemon.daggerinyourface.cache.GameDatabase
import javax.inject.Inject

class GamePagingDaoInjector @Inject constructor(private val database: GameDatabase) :
    GamePagingDao {
    override suspend fun insertGame(vararg data: GamePagingDbEntity) {
        database.gamePagingDao().insertGame(*data)
    }

    override fun loadGame(): DataSource.Factory<Int, GamePagingDbEntity> {
       return database.gamePagingDao().loadGame()
    }
}
