package com.junemon.daggerinyourface.data.util.interfaces

import com.junemon.daggerinyourface.data.db.game.GameDbEntity
import kotlinx.coroutines.flow.Flow

interface GameDaoHelper {

    suspend fun insertGame(vararg data: GameDbEntity)

    fun loadGame(): Flow<List<GameDbEntity>>
}
