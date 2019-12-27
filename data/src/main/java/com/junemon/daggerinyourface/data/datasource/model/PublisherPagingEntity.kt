package com.junemon.daggerinyourface.data.datasource.model

import com.google.gson.annotations.SerializedName
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDbEntity
import com.junemon.daggerinyourface.domain.model.PublisherPagingData

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

fun PublishersPagingEntity.mapToDatabase(): PublisherPagingDbEntity =
    PublisherPagingDbEntity(
        id,
        name,
        imageBackground
    )

fun List<PublishersPagingEntity>.mapToDatabase(): List<PublisherPagingDbEntity> =
    map { it.mapToDatabase() }

fun PublishersPagingEntity.mapToDomain(): PublisherPagingData =
    PublisherPagingData(id, name, imageBackground)

fun List<PublishersPagingEntity>.mapToDomain(): List<PublisherPagingData> = map { it.mapToDomain() }
