package com.junemon.daggerin.util.interfaces

import com.junemon.daggerin.db.game.GameDbEntity
import kotlinx.coroutines.flow.Flow

interface GameDaoHelper {

    suspend fun insertGame(vararg  data:GameDbEntity)

    fun loadGame():Flow<List<GameDbEntity>>
}