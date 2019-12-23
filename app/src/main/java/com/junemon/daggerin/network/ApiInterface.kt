package com.junemon.daggerin.network

import com.junemon.daggerin.model.game.GamesDetailEntity
import com.junemon.daggerin.model.game.GamesEntity
import com.junemon.daggerin.model.publisher.PublisherDetailEntity
import com.junemon.daggerin.model.publisher.PublishersEntity
import com.junemon.daggerin.network.ApiConstant.games
import com.junemon.daggerin.network.ApiConstant.publisher
import com.junemon.gamesapi.data.datasource.model.ResultEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET(games)
    fun getGames(): Call<ResultEntity<GamesEntity>>

    @GET("$games/{id}")
    fun getDetailGames(@Path("id") gameId: Int): Call<GamesDetailEntity>

    @GET(publisher)
    fun getPublisher(): Call<ResultEntity<PublishersEntity>>

    @GET("$publisher/{id}")
    fun getDetailPublisher(@Path("id") publisherId: Int): Call<PublisherDetailEntity>
}

object ApiConstant {
    const val games = "games"
    const val publisher = "publishers"
}
