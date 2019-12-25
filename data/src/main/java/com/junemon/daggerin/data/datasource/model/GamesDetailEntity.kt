package com.junemon.daggerin.data.datasource.model

import com.google.gson.annotations.SerializedName
import com.junemon.daggerin.domain.model.GamesDetailData

data class GamesDetailEntity(
    @field:SerializedName("id") val gameId: Int,
    @field:SerializedName("name") val gameName: String,
    @field:SerializedName("description") val gameDescription: String,
    @field:SerializedName("background_image") val gameImage: String
)

fun GamesDetailEntity.mapToDomain(): GamesDetailData =
    GamesDetailData(gameId, gameName, gameDescription, gameImage)
