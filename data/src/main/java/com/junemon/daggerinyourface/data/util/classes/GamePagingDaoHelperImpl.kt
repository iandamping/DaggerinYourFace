package com.junemon.daggerinyourface.data.util.classes

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.db.game.paging.GamePagingDao
import com.junemon.daggerinyourface.data.util.interfaces.GamePagingDaoHelper
import com.junemon.daggerinyourface.model.data.database.game.GamePagingDbEntity
import javax.inject.Inject

class GamePagingDaoHelperImpl @Inject constructor(private val gamePagingDao: GamePagingDao) : GamePagingDaoHelper {
    override suspend fun insertGame(vararg data: GamePagingDbEntity) {
        gamePagingDao.insertGame(*data)
    }

    override fun loadGame(): DataSource.Factory<Int, GamePagingDbEntity> {
        return gamePagingDao.loadGame()
    }
}
