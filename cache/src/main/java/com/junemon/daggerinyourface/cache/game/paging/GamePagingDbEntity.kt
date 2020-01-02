package com.junemon.daggerinyourface.cache.game.paging

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_game_pagination")
data class GamePagingDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "game_id") val gameId: Int,
    @ColumnInfo(name = "game_name") val gameName: String,
    @ColumnInfo(name = "game_image") val gameImage: String
)