package com.junemon.daggerinyourface.data.data.datasource

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.datasource.model.GamesDetailEntity
import com.junemon.daggerinyourface.data.datasource.model.GamesEntity
import com.junemon.daggerinyourface.data.datasource.model.GamesPagingEntity
import com.junemon.daggerinyourface.data.db.game.paging.GamePagingDbEntity
import com.junemon.daggerinyourface.domain.model.GameData
import kotlinx.coroutines.flow.Flow

interface GameRemoteDataSource {
    suspend fun getGame(): List<GamesEntity>

    suspend fun getDetailGame(gameID: Int): GamesDetailEntity

    suspend fun getPaginationGame(page: Int): List<GamesPagingEntity>
}

interface GameCacheDataSource {
    suspend fun setCache(data: List<GameData>)
    suspend fun setPagingCache(data: List<GamePagingDbEntity>)
    fun getCache(): Flow<List<GameData>>
    fun getPagingCache(): DataSource.Factory<Int, GamePagingDbEntity>
}
