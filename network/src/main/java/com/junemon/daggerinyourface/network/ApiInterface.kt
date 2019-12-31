package com.junemon.daggerinyourface.network

import com.junemon.daggerinyourface.model.data.remote.game.GamesDetailEntity
import com.junemon.daggerinyourface.model.data.remote.game.GamesEntity
import com.junemon.daggerinyourface.model.data.remote.game.GamesPagingEntity
import com.junemon.daggerinyourface.model.data.remote.publisher.PublisherDetailEntity
import com.junemon.daggerinyourface.model.data.remote.publisher.PublishersEntity
import com.junemon.daggerinyourface.model.data.remote.publisher.PublishersPagingEntity
import com.junemon.daggerinyourface.network.ApiConstant.games
import com.junemon.daggerinyourface.network.ApiConstant.publisher
import com.junemon.gamesapi.data.datasource.model.ResultEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET(games)
    fun getGames(): Call<ResultEntity<GamesEntity>>

    @GET("$games/{id}")
    fun getDetailGames(@Path("id") gameId: Int): Call<GamesDetailEntity>

    @GET(games)
    fun getPaginationGames(@Query("page") gamePage: Int): Call<ResultEntity<GamesPagingEntity>>

    @GET(publisher)
    fun getPublisher(): Call<ResultEntity<PublishersEntity>>

    @GET("$publisher/{id}")
    fun getDetailPublisher(@Path("id") publisherId: Int): Call<PublisherDetailEntity>

    @GET(publisher)
    fun getPaginationPublisher(@Query("page")publisherPage: Int): Call<ResultEntity<PublishersPagingEntity>>
}

internal object ApiConstant {
    const val games = "games"
    const val publisher = "publishers"
}
