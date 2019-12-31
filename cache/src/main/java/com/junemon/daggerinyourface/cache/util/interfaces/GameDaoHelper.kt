package com.junemon.daggerinyourface.cache.util.interfaces

import com.junemon.daggerinyourface.data.db.game.normal.GameDbEntity
import kotlinx.coroutines.flow.Flow

interface GameDaoHelper {

    suspend fun insertGame(vararg data: GameDbEntity)

    fun loadGame(): Flow<List<GameDbEntity>>
}
