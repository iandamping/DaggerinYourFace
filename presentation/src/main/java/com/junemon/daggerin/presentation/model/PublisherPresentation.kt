package com.junemon.daggerin.presentation.model

import com.junemon.daggerin.domain.model.PublishersData

class PublisherPresentation(
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
