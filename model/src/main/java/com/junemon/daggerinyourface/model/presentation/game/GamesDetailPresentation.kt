package com.junemon.daggerinyourface.model.presentation.game

import com.junemon.daggerinyourface.model.domain.game.GamesDetailData

class GamesDetailPresentation(
    val gameId: Int,
    val gameName: String,
    val gameDescription: String,
    val gameImage: String
)

fun GamesDetailData.mapToPresentation(): GamesDetailPresentation =
    GamesDetailPresentation(
        gameId,
        gameName,
        gameDescription,
        gameImage
    )
