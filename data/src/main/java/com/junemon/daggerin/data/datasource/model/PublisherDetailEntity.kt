package com.junemon.daggerin.data.datasource.model

import com.google.gson.annotations.SerializedName
import com.junemon.daggerin.domain.model.PublishersDetailData

data class PublisherDetailEntity(
    @field:SerializedName("name") val publisherName: String,
    @field:SerializedName("image_background") val publisherImage: String,
    @field:SerializedName("description") val description: String
)

fun PublisherDetailEntity.mapToDomain(): PublishersDetailData =
    PublishersDetailData(publisherName, publisherImage, description)
