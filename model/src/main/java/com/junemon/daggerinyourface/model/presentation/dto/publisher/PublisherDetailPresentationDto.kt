package com.junemon.daggerinyourface.model.presentation.dto.publisher

import com.junemon.daggerinyourface.model.domain.publisher.PublishersDetailData
import com.junemon.daggerinyourface.model.presentation.publisher.PublisherDetailPresentation


/**
 * Created by Ian Damping on 31,December,2019
 * Github https://github.com/iandamping
 * Indonesia.
 */
fun PublishersDetailData.mapToPresentation(): PublisherDetailPresentation =
    PublisherDetailPresentation(
        publisherName,
        publisherImage,
        description
    )

