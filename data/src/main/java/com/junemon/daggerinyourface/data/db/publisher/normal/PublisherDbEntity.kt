package com.junemon.daggerinyourface.data.db.publisher.normal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.junemon.daggerinyourface.domain.model.PublishersData

@Entity(tableName = "table_publisher")
data class PublisherDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "publisher_id") val publisherId: Int,
    @ColumnInfo(name = "publisher_name") val publisherName: String,
    @ColumnInfo(name = "publisher_image") val publisherImage: String
)

fun PublisherDbEntity.mapToDomain(): PublishersData =
    PublishersData(publisherId, publisherName, publisherImage)

fun List<PublisherDbEntity>.mapToDomain(): List<PublishersData> = map { it.mapToDomain() }

fun PublishersData.mapToData(): PublisherDbEntity =
    PublisherDbEntity(
        publisherId,
        publisherName,
        publisherImage
    )

fun List<PublishersData>.mapToData(): List<PublisherDbEntity> = map { it.mapToData() }
