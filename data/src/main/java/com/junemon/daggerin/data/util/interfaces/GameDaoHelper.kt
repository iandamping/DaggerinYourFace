package com.junemon.daggerin.data.util.interfaces

import com.junemon.daggerin.data.db.game.GameDbEntity
import kotlinx.coroutines.flow.Flow

interface GameDaoHelper {

    suspend fun insertGame(vararg data: GameDbEntity)

    fun loadGame(): Flow<List<GameDbEntity>>
}
