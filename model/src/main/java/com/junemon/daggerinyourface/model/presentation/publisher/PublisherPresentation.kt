package com.junemon.daggerinyourface.model.presentation.publisher

import com.junemon.daggerinyourface.model.domain.publisher.PublishersData

data class PublisherPresentation(
    val publisherId: Int,
    val publisherName: String,
    val publisherImage: String
)


