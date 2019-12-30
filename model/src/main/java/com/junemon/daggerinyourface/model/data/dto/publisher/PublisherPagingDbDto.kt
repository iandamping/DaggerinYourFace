package com.junemon.daggerinyourface.model.data.dto.publisher

import com.junemon.daggerinyourface.model.domain.publisher.PublisherPagingData
import com.junemon.daggerinyourface.model.data.database.publisher.PublisherPagingDbEntity


fun PublisherPagingDbEntity.mapToDomain(): PublisherPagingData =
    PublisherPagingData(publisherId, publisherName, publisherImage)

fun List<PublisherPagingDbEntity>.mapToDomain(): List<PublisherPagingData> =
    map { it.mapToDomain() }

fun PublisherPagingData.mapToData(): PublisherPagingDbEntity =
    PublisherPagingDbEntity(
        publisherId,
        publisherName,
        publisherImage
    )

fun List<PublisherPagingData>.mapToData(): List<PublisherPagingDbEntity> = map { it.mapToData() }
