package com.junemon.daggerinyourface.core.data.datasource.remote

import com.junemon.daggerinyourface.core.data.datasource.remote.model.GamesDetailResponse
import com.junemon.daggerinyourface.core.data.datasource.remote.model.GamesResponse
import com.junemon.daggerinyourface.core.domain.model.DataHelper
import com.junemon.daggerinyourface.core.domain.model.GamesDetailData

interface GameRemoteDataSource {
    suspend fun getGame(): DataHelper<List<GamesResponse>>

    suspend fun getDetailGame(gameID: Int): DataHelper<GamesDetailData>

}