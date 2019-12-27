package com.junemon.daggerinyourface.data.db.game.normal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.junemon.daggerinyourface.domain.model.GameData

@Entity(tableName = "table_game")
data class GameDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "game_id") val gameId: Int,
    @ColumnInfo(name = "game_name") val gameName: String,
    @ColumnInfo(name = "game_image") val gameImage: String
)

fun GameDbEntity.mapToDomain(): GameData = GameData(gameId, gameName, gameImage)

fun List<GameDbEntity>.mapToDomain(): List<GameData> = map { it.mapToDomain() }

fun GameData.mapToData(): GameDbEntity =
    GameDbEntity(
        gameId,
        gameName,
        gameImage
    )

fun List<GameData>.mapToData(): List<GameDbEntity> = map { it.mapToData() }