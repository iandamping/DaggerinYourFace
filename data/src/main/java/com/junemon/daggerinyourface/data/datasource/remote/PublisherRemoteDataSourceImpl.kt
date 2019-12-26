package com.junemon.daggerinyourface.data.datasource.remote

import com.junemon.daggerinyourface.data.data.datasource.PublisherRemoteDataSource
import com.junemon.daggerinyourface.data.datasource.model.mapToDomain
import com.junemon.daggerinyourface.data.network.ApiInterface
import com.junemon.daggerinyourface.data.util.interfaces.RetrofitHelper
import com.junemon.daggerinyourface.domain.model.PublishersData
import com.junemon.daggerinyourface.domain.model.PublishersDetailData
import kotlinx.coroutines.CompletableDeferred
import javax.inject.Inject

class PublisherRemoteDataSourceImpl @Inject constructor(
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper
) : PublisherRemoteDataSource {
    override suspend fun getPublisher(): List<PublishersData> {
        val data: CompletableDeferred<List<PublishersData>> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getPublisher().doOneShot().data.mapToDomain())
        }
        return data.await()
    }

    override suspend fun getDetailPublisher(publisherID: Int): PublishersDetailData {
        val data: CompletableDeferred<PublishersDetailData> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getDetailPublisher(publisherID).doOneShot().mapToDomain())
        }
        return data.await()
    }
}
