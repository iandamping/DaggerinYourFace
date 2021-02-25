package com.junemon.daggerinyourface.core.domain.repository

import com.junemon.daggerinyourface.core.domain.model.ConsumeResult
import com.junemon.daggerinyourface.core.domain.model.PublishersDetailData
import com.junemon.daggerinyourface.core.presentation.model.publisher.Publisher
import com.junemon.daggerinyourface.core.presentation.model.publisher.PublisherDetail
import kotlinx.coroutines.flow.Flow

interface PublisherRepository {

    fun getPublisher(): Flow<ConsumeResult<List<Publisher>>>

    fun getDetailPublisher(publisherID: Int): Flow<ConsumeResult<PublisherDetail>>

}
