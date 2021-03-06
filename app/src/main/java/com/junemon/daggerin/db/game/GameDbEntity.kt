package com.junemon.daggerin.db.game

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_game")
data class GameDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "game_name")  val gameName:String,
    @ColumnInfo(name = "game_image") val gameImage:String
)