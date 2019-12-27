package com.junemon.daggerinyourface.data.datasource.remote

import com.junemon.daggerinyourface.data.data.datasource.PublisherRemoteDataSource
import com.junemon.daggerinyourface.data.datasource.model.PublisherDetailEntity
import com.junemon.daggerinyourface.data.datasource.model.PublishersEntity
import com.junemon.daggerinyourface.data.datasource.model.PublishersPagingEntity
import com.junemon.daggerinyourface.data.network.ApiInterface
import com.junemon.daggerinyourface.data.util.interfaces.RetrofitHelper
import javax.inject.Inject
import kotlinx.coroutines.CompletableDeferred

class PublisherRemoteDataSourceImpl @Inject constructor(
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper
) : PublisherRemoteDataSource {
    override suspend fun getPublisher(): List<PublishersEntity> {
        val data: CompletableDeferred<List<PublishersEntity>> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getPublisher().doOneShot().data)
        }
        return data.await()
    }

    override suspend fun getDetailPublisher(publisherID: Int): PublisherDetailEntity {
        val data: CompletableDeferred<PublisherDetailEntity> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getDetailPublisher(publisherID).doOneShot())
        }
        return data.await()
    }

    override suspend fun getPaginationPublisher(page: Int): List<PublishersPagingEntity> {
        val data: CompletableDeferred<List<PublishersPagingEntity>> = CompletableDeferred()
        retrofitHelper.run {
            data.complete(api.getPaginationPublisher(page).doOneShot().data)
        }
        return data.await()
    }
}
