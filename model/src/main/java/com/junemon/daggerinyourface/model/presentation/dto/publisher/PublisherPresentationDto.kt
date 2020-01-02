package com.junemon.daggerinyourface.model.presentation.dto.publisher

import com.junemon.daggerinyourface.model.domain.publisher.PublishersData
import com.junemon.daggerinyourface.model.presentation.publisher.PublisherPresentation


/**
 * Created by Ian Damping on 31,December,2019
 * Github https://github.com/iandamping
 * Indonesia.
 */
fun PublishersData.mapToPresentation(): PublisherPresentation =
    PublisherPresentation(
        publisherId,
        publisherName,
        publisherImage
    )

fun List<PublishersData>.mapToPresentation(): List<PublisherPresentation> =
    map { it.mapToPresentation() }