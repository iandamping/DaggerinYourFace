package com.junemon.daggerinyourface.cache.util.dto.publisher


import com.junemon.daggerinyourface.cache.publisher.normal.PublisherDbEntity
import com.junemon.daggerinyourface.model.domain.publisher.PublishersData


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
