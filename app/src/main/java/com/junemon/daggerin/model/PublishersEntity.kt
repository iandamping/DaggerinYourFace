package com.junemon.daggerin.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import com.junemon.daggerin.db.publisher.PublisherDbEntity

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

fun PublishersEntity.mapToDatabase(): PublisherDbEntity = PublisherDbEntity(id,name, imageBackground)

fun List<PublishersEntity>.mapToDatabase(): List<PublisherDbEntity> = map { it.mapToDatabase() }

object PublisherCallback {

    val publisherDiffCallbacks = object : DiffUtil.ItemCallback<PublisherDbEntity>() {
        override fun areItemsTheSame(
            oldItem: PublisherDbEntity,
            newItem: PublisherDbEntity
        ): Boolean =
            oldItem.publisherName == newItem.publisherName

        override fun areContentsTheSame(
            oldItem: PublisherDbEntity,
            newItem: PublisherDbEntity
        ): Boolean =
            oldItem == newItem
    }
}
