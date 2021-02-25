package com.junemon.daggerinyourface.core.data.datasource.remote

import com.junemon.daggerinyourface.core.data.datasource.remote.model.PublisherDetailResponse
import com.junemon.daggerinyourface.core.data.datasource.remote.model.PublishersResponse
import com.junemon.daggerinyourface.core.domain.model.DataHelper
import com.junemon.daggerinyourface.core.domain.model.PublishersDetailData

interface PublisherRemoteDataSource {
    suspend fun getPublisher(): DataHelper<List<PublishersResponse>>

    suspend fun getDetailPublisher(publisherID: Int): DataHelper<PublishersDetailData>

}