package com.junemon.daggerinyourface.model.data.remote.publisher

import com.google.gson.annotations.SerializedName

data class GamesPagingItem(
    @SerializedName("added")
    val added: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("slug")
    val slug: String = ""
)

data class PublishersPagingEntity(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("games")
    val games: List<GamesPagingItem>?,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image_background")
    val imageBackground: String = ""
)