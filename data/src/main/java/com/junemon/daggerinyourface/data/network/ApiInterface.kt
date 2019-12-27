package com.junemon.daggerinyourface.data.network

import com.junemon.daggerinyourface.data.datasource.model.*
import com.junemon.daggerinyourface.data.network.ApiConstant.games
import com.junemon.daggerinyourface.data.network.ApiConstant.publisher
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

object ApiConstant {
    const val games = "games"
    const val publisher = "publishers"
}
