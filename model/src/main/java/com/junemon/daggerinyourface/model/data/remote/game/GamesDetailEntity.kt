package com.junemon.daggerinyourface.model.data.remote.game

import com.google.gson.annotations.SerializedName

data class GamesDetailEntity(
    @field:SerializedName("id") val gameId: Int,
    @field:SerializedName("name") val gameName: String,
    @field:SerializedName("description") val gameDescription: String,
    @field:SerializedName("background_image") val gameImage: String
)
