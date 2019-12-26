package com.junemon.daggerinyourface.data.datasource.remote

import com.junemon.daggerinyourface.data.data.datasource.GameRemoteDataSource
import com.junemon.daggerinyourface.data.datasource.model.mapToDomain
import com.junemon.daggerinyourface.data.network.ApiInterface
import com.junemon.daggerinyourface.data.util.interfaces.RetrofitHelper
import com.junemon.daggerinyourface.domain.model.GameData
import com.junemon.daggerinyourface.domain.model.GamesDetailData
import javax.inject.Inject
import kotlinx.coroutines.CompletableDeferred

class GameRemoteDataSourceImpl @Inject constructor(
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper
) : GameRemoteDataSource {
    override suspend fun getGame(): List<GameData> {
        val data: CompletableDeferred<List<GameData>> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getGames().doOneShot().data.mapToDomain())
        }
        return data.await()
    }

    override suspend fun getDetailGame(gameID: Int): GamesDetailData {
        val data: CompletableDeferred<GamesDetailData> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getDetailGames(gameID).doOneShot().mapToDomain())
        }
        return data.await()
    }
}
