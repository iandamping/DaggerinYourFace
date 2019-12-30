package com.junemon.daggerinyourface.model.presentation.game

import com.junemon.daggerinyourface.model.domain.game.GameData

data class GamePresentation(
    val gameId: Int,
    val gameName: String,
    val gameImage: String
)

fun GameData.mapToPresentation(): GamePresentation =
    GamePresentation(
        gameId,
        gameName,
        gameImage
    )

fun List<GameData>.mapToPresentation(): List<GamePresentation> = map { it.mapToPresentation() }
