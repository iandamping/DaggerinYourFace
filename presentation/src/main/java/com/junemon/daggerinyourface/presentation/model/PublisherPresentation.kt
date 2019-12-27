package com.junemon.daggerinyourface.presentation.model

import com.junemon.daggerinyourface.domain.model.PublishersData

data class PublisherPresentation(
    val publisherId: Int,
    val publisherName: String,
    val publisherImage: String
)

fun PublishersData.mapToPresentation(): PublisherPresentation =
    PublisherPresentation(
        publisherId,
        publisherName,
        publisherImage
    )

fun List<PublishersData>.mapToPresentation(): List<PublisherPresentation> =
    map { it.mapToPresentation() }
