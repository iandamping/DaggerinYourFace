package com.junemon.daggerinyourface.cache.game.paging

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.junemon.daggerinyourface.cache.game.paging.GamePagingDbEntity

@Dao
interface GamePagingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(vararg data: GamePagingDbEntity)

    @Query("SELECT * FROM table_game_pagination")
    fun loadGame(): DataSource.Factory<Int, GamePagingDbEntity>
}
