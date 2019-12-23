package com.junemon.daggerin.domain.model

import com.junemon.daggerin.data.db.game.GameDbEntity

data class GameData(
    val gameId: Int,
    val gameName: String,
    val gameImage: String
)

fun GameData.mapToData(): GameDbEntity = GameDbEntity(gameId, gameName, gameImage)

fun List<GameData>.mapToData(): List<GameDbEntity> = map { it.mapToData() }
