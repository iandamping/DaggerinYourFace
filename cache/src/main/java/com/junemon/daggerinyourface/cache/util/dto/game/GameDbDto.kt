package com.junemon.daggerinyourface.cache.util.dto.game

import com.junemon.daggerinyourface.cache.game.normal.GameDbEntity
import com.junemon.daggerinyourface.model.domain.game.GameData


fun GameDbEntity.mapToDomain(): GameData = GameData(gameId, gameName, gameImage)

fun List<GameDbEntity>.mapToDomain(): List<GameData> = map { it.mapToDomain() }

fun GameData.mapToData(): GameDbEntity =
    GameDbEntity(
        gameId,
        gameName,
        gameImage
    )

fun List<GameData>.mapToData(): List<GameDbEntity> = map { it.mapToData() }
