package com.junemon.daggerinyourface.data.util.dto.publisher

import com.junemon.daggerinyourface.data.db.publisher.normal.PublisherDbEntity
import com.junemon.daggerinyourface.model.domain.publisher.PublishersData
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
