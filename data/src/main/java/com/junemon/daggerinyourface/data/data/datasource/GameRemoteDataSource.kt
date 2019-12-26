package com.junemon.daggerinyourface.data.data.datasource

import com.junemon.daggerinyourface.domain.model.GameData
import com.junemon.daggerinyourface.domain.model.GamesDetailData
import kotlinx.coroutines.flow.Flow

interface GameRemoteDataSource {
    suspend fun getGame(): List<GameData>

    suspend fun getDetailGame(gameID: Int): GamesDetailData
}

interface GameCacheDataSource {
    suspend fun setCache(data: List<GameData>)
    fun getCache(): Flow<List<GameData>>
}
