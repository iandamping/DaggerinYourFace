package com.junemon.daggerinyourface.cache.util.dto.publisher

import com.junemon.daggerinyourface.cache.publisher.paging.PublisherPagingDbEntity
import com.junemon.daggerinyourface.model.domain.publisher.PublisherPagingData
import com.junemon.daggerinyourface.model.data.remote.publisher.PublishersPagingEntity


fun PublishersPagingEntity.mapToDatabase(): PublisherPagingDbEntity =
    PublisherPagingDbEntity(
        id,
        name,
        imageBackground
    )

fun List<PublishersPagingEntity>.mapToDatabase(): List<PublisherPagingDbEntity> =
    map { it.mapToDatabase() }

fun PublishersPagingEntity.mapToDomain(): PublisherPagingData =
    PublisherPagingData(id, name, imageBackground)

fun List<PublishersPagingEntity>.mapToDomain(): List<PublisherPagingData> = map { it.mapToDomain() }
