package com.junemon.daggerinyourface.core.data.datasource.remote

import com.junemon.daggerinyourface.core.data.datasource.remote.helper.BaseResponse
import com.junemon.daggerinyourface.core.data.datasource.remote.model.PublisherDetailResponse
import com.junemon.daggerinyourface.core.data.datasource.remote.model.PublishersResponse
import com.junemon.daggerinyourface.core.data.datasource.remote.model.RemoteServiceResult
import com.junemon.daggerinyourface.core.data.datasource.remote.retrofit.ApiInterface
import com.junemon.daggerinyourface.core.domain.model.DataHelper
import com.junemon.daggerinyourface.core.domain.model.PublishersDetailData
import com.junemon.daggerinyourface.core.util.dto.publisher.mapToDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * Created by Ian Damping on 17,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
class PublisherRemoteDataSourceImpl @Inject constructor(
    private val api: ApiInterface,
    private val defaultDispatcher: CoroutineDispatcher
) : BaseResponse(), PublisherRemoteDataSource {
    override suspend fun getPublisher(): DataHelper<List<PublishersResponse>> {
        return withContext(defaultDispatcher) {
            when (val response = doOneShots { api.getPublisher() }) {
                is RemoteServiceResult.Error -> {
                    DataHelper.RemoteSourceError(Exception(response.exception))
                }
                is RemoteServiceResult.Success -> {
                    val dataArray = response.data.data
                    when {
                        dataArray.isNullOrEmpty() -> {
                            DataHelper.RemoteSourceEmpty
                        }
                        else -> DataHelper.RemoteSourceValue(dataArray)
                    }
                }
            }
        }
    }

    override suspend fun getDetailPublisher(publisherID: Int): DataHelper<PublishersDetailData> {
        return withContext(defaultDispatcher) {
            when (val response = doOneShots { api.getDetailPublisher(publisherID) }) {
                is RemoteServiceResult.Error -> {
                    DataHelper.RemoteSourceError(Exception(response.exception))
                }
                is RemoteServiceResult.Success -> {
                    val data = response.data
                    DataHelper.RemoteSourceValue(data.mapToDomain())
                }
            }
        }
    }
}