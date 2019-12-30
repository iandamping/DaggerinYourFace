package com.junemon.daggerinyourface.model.data.dto.game

import com.junemon.daggerinyourface.model.domain.game.GameData
import com.junemon.daggerinyourface.model.data.database.game.GameDbEntity


fun GameDbEntity.mapToDomain(): GameData = GameData(gameId, gameName, gameImage)

fun List<GameDbEntity>.mapToDomain(): List<GameData> = map { it.mapToDomain() }

fun GameData.mapToData(): GameDbEntity =
    GameDbEntity(
        gameId,
        gameName,
        gameImage
    )

fun List<GameData>.mapToData(): List<GameDbEntity> = map { it.mapToData() }
