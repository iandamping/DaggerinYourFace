package com.junemon.daggerinyourface.cache.util.dto.publisher

import com.junemon.daggerinyourface.cache.publisher.paging.PublisherPagingDbEntity
import com.junemon.daggerinyourface.model.domain.publisher.PublisherPagingData


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
