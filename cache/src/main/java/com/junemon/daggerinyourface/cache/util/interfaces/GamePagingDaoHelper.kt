package com.junemon.daggerinyourface.cache.util.interfaces

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.db.game.paging.GamePagingDbEntity

interface GamePagingDaoHelper {

    suspend fun insertGame(vararg data: GamePagingDbEntity)

    fun loadGame(): DataSource.Factory<Int, GamePagingDbEntity>
}
