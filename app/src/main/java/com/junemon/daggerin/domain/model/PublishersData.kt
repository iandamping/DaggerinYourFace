package com.junemon.daggerin.domain.model

import com.junemon.daggerin.data.db.publisher.PublisherDbEntity

data class PublishersData(
    val publisherId: Int,
    val publisherName: String,
    val publisherImage: String
)

fun PublishersData.mapToData(): PublisherDbEntity =
    PublisherDbEntity(publisherId, publisherName, publisherImage)

fun List<PublishersData>.mapToDomain(): List<PublisherDbEntity> = map { it.mapToData() }
