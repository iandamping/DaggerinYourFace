package com.junemon.daggerinyourface.core.data.datasource.remote.retrofit

import com.junemon.daggerinyourface.core.data.datasource.remote.model.*
import com.junemon.daggerinyourface.core.util.Constant.games
import com.junemon.daggerinyourface.core.util.Constant.publisher
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET(games)
    suspend fun getGames(): Response<ResultResponse<GamesResponse>>

    @GET("$games/{id}")
    suspend fun getDetailGames(@Path("id") gameId: Int): Response<GamesDetailResponse>

    @GET(publisher)
    suspend fun getPublisher(): Response<ResultResponse<PublishersResponse>>

    @GET("$publisher/{id}")
    suspend fun getDetailPublisher(@Path("id") publisherId: Int): Response<PublisherDetailResponse>

}

