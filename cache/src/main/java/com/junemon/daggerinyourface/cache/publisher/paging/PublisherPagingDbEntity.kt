package com.junemon.daggerinyourface.data.db.publisher.paging
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "table_publisher_pagination")
data class PublisherPagingDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "publisher_id") val publisherId: Int,
    @ColumnInfo(name = "publisher_name") val publisherName: String,
    @ColumnInfo(name = "publisher_image") val publisherImage: String
)