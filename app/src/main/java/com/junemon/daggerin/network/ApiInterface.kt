package com.junemon.daggerin.network

import com.junemon.daggerin.model.GamesEntity
import com.junemon.daggerin.model.PublishersEntity
import com.junemon.daggerin.network.ApiConstant.games
import com.junemon.daggerin.network.ApiConstant.publisher
import com.junemon.gamesapi.data.datasource.model.ResultEntity
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(games)
    fun getGames(): Call<ResultEntity<GamesEntity>>

    @GET(publisher)
    fun getPublisher(): Call<ResultEntity<PublishersEntity>>
}

object ApiConstant {
    const val games = "games"
    const val publisher = "publishers"
}