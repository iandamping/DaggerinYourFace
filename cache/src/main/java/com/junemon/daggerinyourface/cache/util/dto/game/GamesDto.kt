package com.junemon.daggerinyourface.cache.util.dto.game

import com.junemon.daggerinyourface.cache.game.normal.GameDbEntity
import com.junemon.daggerinyourface.model.domain.game.GameData
import com.junemon.daggerinyourface.model.data.remote.game.GamesEntity


fun GamesEntity.mapToDatabase(): GameDbEntity =
    GameDbEntity(
        id,
        name,
        backgroundImage
    )

fun List<GamesEntity>.mapToDatabase(): List<GameDbEntity> = map { it.mapToDatabase() }

fun GamesEntity.mapToDomain(): GameData =
    GameData(id, name, backgroundImage)

fun List<GamesEntity>.mapToDomain(): List<GameData> = map { it.mapToDomain() }
