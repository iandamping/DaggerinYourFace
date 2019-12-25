package com.junemon.daggerin.data.network

import com.junemon.daggerin.data.datasource.model.GamesDetailEntity
import com.junemon.daggerin.data.datasource.model.GamesEntity
import com.junemon.daggerin.data.datasource.model.PublisherDetailEntity
import com.junemon.daggerin.data.datasource.model.PublishersEntity
import com.junemon.daggerin.data.network.ApiConstant.games
import com.junemon.daggerin.data.network.ApiConstant.publisher
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
