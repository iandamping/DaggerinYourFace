package com.junemon.daggerinyourface.data.datasource.remote

import com.junemon.daggerinyourface.data.data.datasource.GameRemoteDataSource
import com.junemon.daggerinyourface.network.util.interfaces.RetrofitHelper
import com.junemon.daggerinyourface.model.data.remote.game.GamesDetailEntity
import com.junemon.daggerinyourface.model.data.remote.game.GamesEntity
import com.junemon.daggerinyourface.model.data.remote.game.GamesPagingEntity
import com.junemon.daggerinyourface.network.ApiInterface
import javax.inject.Inject
import kotlinx.coroutines.CompletableDeferred

class GameRemoteDataSourceImpl @Inject constructor(
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper
) : GameRemoteDataSource {
    override suspend fun getGame(): List<GamesEntity> {
        val data: CompletableDeferred<List<GamesEntity>> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getGames().doOneShot().data)
        }
        return data.await()
    }

    override suspend fun getDetailGame(gameID: Int): GamesDetailEntity {
        val data: CompletableDeferred<GamesDetailEntity> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getDetailGames(gameID).doOneShot())
        }
        return data.await()
    }

    override suspend fun getPaginationGame(page: Int): List<GamesPagingEntity> {
        val data: CompletableDeferred<List<GamesPagingEntity>> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getPaginationGames(page).doOneShot().data)
        }
        return data.await()
    }
}
