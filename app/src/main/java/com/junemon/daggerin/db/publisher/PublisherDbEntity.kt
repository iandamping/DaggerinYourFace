package com.junemon.daggerin.db.publisher

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_publisher")
data class PublisherDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "publisher_id") val publisherId:Int,
    @ColumnInfo(name = "publisher_name") val publisherName: String,
    @ColumnInfo(name = "publisher_image") val publisherImage: String
)