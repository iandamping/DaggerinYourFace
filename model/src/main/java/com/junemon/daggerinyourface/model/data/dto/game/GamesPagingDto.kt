package com.junemon.daggerinyourface.model.data.dto.game

import com.junemon.daggerinyourface.model.domain.game.GamePagingData
import com.junemon.daggerinyourface.model.data.database.game.GamePagingDbEntity
import com.junemon.daggerinyourface.model.data.remote.game.GamesPagingEntity


fun GamesPagingEntity.mapToDatabase(): GamePagingDbEntity =
    GamePagingDbEntity(
        id,
        name,
        backgroundImage
    )

fun List<GamesPagingEntity>.mapToDatabase(): List<GamePagingDbEntity> = map { it.mapToDatabase() }

fun GamesPagingEntity.mapToDomain(): GamePagingData =
    GamePagingData(id, name, backgroundImage)

fun List<GamesPagingEntity>.mapToDomain(): List<GamePagingData> = map { it.mapToDomain() }
