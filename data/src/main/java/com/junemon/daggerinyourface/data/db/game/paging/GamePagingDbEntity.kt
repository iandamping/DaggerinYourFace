package com.junemon.daggerinyourface.data.db.game.paging

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.junemon.daggerinyourface.domain.model.GamePagingData

@Entity(tableName = "table_game_pagination")
data class GamePagingDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "game_id") val gameId: Int,
    @ColumnInfo(name = "game_name") val gameName: String,
    @ColumnInfo(name = "game_image") val gameImage: String
)

fun GamePagingDbEntity.mapToDomain(): GamePagingData = GamePagingData(gameId, gameName, gameImage)

fun List<GamePagingDbEntity>.mapToDomain(): List<GamePagingData> = map { it.mapToDomain() }

fun GamePagingData.mapToData(): GamePagingDbEntity =
    GamePagingDbEntity(
        gameId,
        gameName,
        gameImage
    )

fun List<GamePagingData>.mapToData(): List<GamePagingDbEntity> = map { it.mapToData() }
