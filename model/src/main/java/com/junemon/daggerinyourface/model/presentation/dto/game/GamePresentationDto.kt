package com.junemon.daggerinyourface.model.presentation.dto.game

import com.junemon.daggerinyourface.model.domain.game.GameData
import com.junemon.daggerinyourface.model.presentation.game.GamePresentation


/**
 * Created by Ian Damping on 31,December,2019
 * Github https://github.com/iandamping
 * Indonesia.
 */
fun GameData.mapToPresentation(): GamePresentation =
    GamePresentation(
        gameId,
        gameName,
        gameImage
    )

fun List<GameData>.mapToPresentation(): List<GamePresentation> = map { it.mapToPresentation() }