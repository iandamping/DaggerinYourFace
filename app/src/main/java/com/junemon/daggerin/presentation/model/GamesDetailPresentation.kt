package com.junemon.daggerin.presentation.model

import com.junemon.daggerin.domain.model.GamesDetailData

class GamesDetailPresentation(
    val gameId: Int,
    val gameName: String,
    val gameDescription: String,
    val gameImage: String
)

fun GamesDetailData.mapToPresentation(): GamesDetailPresentation =
    GamesDetailPresentation(gameId, gameName, gameDescription, gameImage)
