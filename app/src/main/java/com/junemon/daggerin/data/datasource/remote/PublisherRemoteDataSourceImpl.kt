package com.junemon.daggerin.data.datasource.remote

import com.junemon.daggerin.data.data.datasource.PublisherRemoteDataSource
import com.junemon.daggerin.data.datasource.model.mapToDomain
import com.junemon.daggerin.domain.model.PublishersData
import com.junemon.daggerin.domain.model.PublishersDetailData
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import javax.inject.Inject
import kotlinx.coroutines.CompletableDeferred

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
