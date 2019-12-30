package com.junemon.daggerinyourface.model.presentation.publisher

import com.junemon.daggerinyourface.model.domain.publisher.PublishersDetailData

data class PublisherDetailPresentation(
    val publisherName: String,
    val publisherImage: String,
    val description: String
)

fun PublishersDetailData.mapToPresentation(): PublisherDetailPresentation =
    PublisherDetailPresentation(
        publisherName,
        publisherImage,
        description
    )
