package com.junemon.daggerin.model.publisher

import com.google.gson.annotations.SerializedName

data class PublisherDetailEntity(
    @field:SerializedName("name") val publisherName: String,
    @field:SerializedName("image_background") val publisherImage: String,
    @field:SerializedName("description") val description: String
)
