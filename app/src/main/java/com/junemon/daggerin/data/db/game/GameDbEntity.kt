package com.junemon.daggerin.data.db.game

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.junemon.daggerin.domain.model.GameData

@Entity(tableName = "table_game")
data class GameDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "game_id") val gameId: Int,
    @ColumnInfo(name = "game_name") val gameName: String,
    @ColumnInfo(name = "game_image") val gameImage: String
)

fun GameDbEntity.mapToDomain(): GameData = GameData(gameId, gameName, gameImage)

fun List<GameDbEntity>.mapToDomain(): List<GameData> = map { it.mapToDomain() }
