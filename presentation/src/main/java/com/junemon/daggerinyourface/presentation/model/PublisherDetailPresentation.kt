package com.junemon.daggerinyourface.presentation.model

import com.junemon.daggerinyourface.domain.model.PublishersDetailData

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
