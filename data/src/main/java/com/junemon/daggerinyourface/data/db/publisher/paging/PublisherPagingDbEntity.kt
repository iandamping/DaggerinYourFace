package com.junemon.daggerinyourface.data.db.publisher.paging

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.junemon.daggerinyourface.domain.model.PublisherPagingData

@Entity(tableName = "table_publisher_pagination")
data class PublisherPagingDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "publisher_id") val publisherId: Int,
    @ColumnInfo(name = "publisher_name") val publisherName: String,
    @ColumnInfo(name = "publisher_image") val publisherImage: String
)

fun PublisherPagingDbEntity.mapToDomain(): PublisherPagingData =
    PublisherPagingData(publisherId, publisherName, publisherImage)

fun List<PublisherPagingDbEntity>.mapToDomain(): List<PublisherPagingData> = map { it.mapToDomain() }

fun PublisherPagingData.mapToData(): PublisherPagingDbEntity =
    PublisherPagingDbEntity(
        publisherId,
        publisherName,
        publisherImage
    )

fun List<PublisherPagingData>.mapToData(): List<PublisherPagingDbEntity> = map { it.mapToData() }
