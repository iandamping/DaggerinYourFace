package com.junemon.daggerinyourface.presentation.model

import com.junemon.daggerinyourface.domain.model.GamesDetailData

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
