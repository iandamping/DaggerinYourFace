package com.junemon.daggerinyourface.data.util.dto.publisher

import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDbEntity
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
