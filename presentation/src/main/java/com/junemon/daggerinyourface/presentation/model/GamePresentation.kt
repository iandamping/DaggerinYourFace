package com.junemon.daggerinyourface.presentation.model

import com.junemon.daggerinyourface.domain.model.GameData

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
