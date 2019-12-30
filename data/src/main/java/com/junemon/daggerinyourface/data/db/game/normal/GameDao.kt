package com.junemon.daggerinyourface.data.db.game.normal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.junemon.daggerinyourface.model.data.database.game.GameDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(vararg data: GameDbEntity)

    @Query("SELECT * FROM table_game")
    fun loadGame(): Flow<List<GameDbEntity>>
}
