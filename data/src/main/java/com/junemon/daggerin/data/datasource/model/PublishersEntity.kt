package com.junemon.daggerin.data.datasource.model

import com.google.gson.annotations.SerializedName
import com.junemon.daggerin.data.db.publisher.PublisherDbEntity
import com.junemon.daggerin.domain.model.PublishersData

data class GamesItem(
    @SerializedName("added")
    val added: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("slug")
    val slug: String = ""
)

data class PublishersEntity(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("games")
    val games: List<GamesItem>?,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image_background")
    val imageBackground: String = ""
)

fun PublishersEntity.mapToDatabase(): PublisherDbEntity =
    PublisherDbEntity(
        id,
        name,
        imageBackground
    )

fun List<PublishersEntity>.mapToDatabase(): List<PublisherDbEntity> = map { it.mapToDatabase() }

fun PublishersEntity.mapToDomain(): PublishersData =
    PublishersData(id, name, imageBackground)

fun List<PublishersEntity>.mapToDomain(): List<PublishersData> = map { it.mapToDomain() }

