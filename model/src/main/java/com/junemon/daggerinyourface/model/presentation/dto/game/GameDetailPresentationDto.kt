package com.junemon.daggerinyourface.model.presentation.dto.game

import com.junemon.daggerinyourface.model.domain.game.GamesDetailData
import com.junemon.daggerinyourface.model.presentation.game.GamesDetailPresentation


/**
 * Created by Ian Damping on 31,December,2019
 * Github https://github.com/iandamping
 * Indonesia.
 */
fun GamesDetailData.mapToPresentation(): GamesDetailPresentation =
    GamesDetailPresentation(
        gameId,
        gameName,
        gameDescription,
        gameImage
    )
