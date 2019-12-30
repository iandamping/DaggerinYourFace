package com.junemon.daggerinyourface.model.data.dto.publisher

import com.junemon.daggerinyourface.model.domain.publisher.PublishersData
import com.junemon.daggerinyourface.model.data.database.publisher.PublisherDbEntity
import com.junemon.daggerinyourface.model.data.remote.publisher.PublishersEntity


fun PublishersEntity.mapToDatabase(): PublisherDbEntity =
    PublisherDbEntity(
        id,
        name,
        imageBackground
    )

fun List<PublishersEntity>.mapToDatabase(): List<PublisherDbEntity> = map { it.mapToDatabase() }

fun PublishersEntity.mapToDomain(): PublishersData =
    PublishersData(id, name, imageBackground)

fun List<PublishersEntity>.mapToDomain(): List<PublishersData> = map { it.mapToDomain() }
