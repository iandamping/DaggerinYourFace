package com.junemon.daggerinyourface.model.data.dto.publisher


import com.junemon.daggerinyourface.model.domain.publisher.PublishersData
import com.junemon.daggerinyourface.model.data.database.publisher.PublisherDbEntity


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
