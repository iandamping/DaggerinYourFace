package com.junemon.daggerinyourface.data.util.interfaces

import androidx.paging.DataSource
import com.junemon.daggerinyourface.model.data.database.game.GamePagingDbEntity

interface GamePagingDaoHelper {

    suspend fun insertGame(vararg data: GamePagingDbEntity)

    fun loadGame(): DataSource.Factory<Int, GamePagingDbEntity>
}
