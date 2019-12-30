package com.junemon.daggerinyourface.model.data.dto.game

import com.junemon.daggerinyourface.model.domain.game.GamesDetailData
import com.junemon.daggerinyourface.model.data.remote.game.GamesDetailEntity


fun GamesDetailEntity.mapToDomain(): GamesDetailData =
    GamesDetailData(gameId, gameName, gameDescription, gameImage)
