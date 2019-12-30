package com.junemon.daggerinyourface.model.data.dto.publisher

import com.junemon.daggerinyourface.model.domain.publisher.PublishersDetailData
import com.junemon.daggerinyourface.model.data.remote.publisher.PublisherDetailEntity

fun PublisherDetailEntity.mapToDomain(): PublishersDetailData =
    PublishersDetailData(publisherName, publisherImage, description)
