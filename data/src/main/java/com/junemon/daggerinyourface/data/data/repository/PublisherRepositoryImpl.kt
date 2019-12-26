package com.junemon.daggerinyourface.data.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.junemon.daggerinyourface.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerinyourface.data.data.datasource.PublisherRemoteDataSource
import com.junemon.daggerinyourface.domain.model.PublishersData
import com.junemon.daggerinyourface.domain.model.PublishersDetailData
import com.junemon.daggerinyourface.domain.model.ResultRemoteToConsume
import com.junemon.daggerinyourface.domain.model.ResultToConsume
import com.junemon.daggerinyourface.domain.repository.PublisherRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class PublisherRepositoryImpl @Inject constructor(
    private val cacheDataSource:PublisherCacheDataSource,
    private val remoteDataSource:PublisherRemoteDataSource
) : PublisherRepository {
    override fun getCache(): LiveData<ResultToConsume<List<PublishersData>>> {
        return liveData() {
            val disposables = emitSource(cacheDataSource.getCache().map {
                ResultToConsume.Loading(it)
            }.asLiveData())
            try {
                val data = remoteDataSource.getPublisher()
                disposables.dispose()
                check(data.isNotEmpty()) {
                    " empty data from service"
                }
                cacheDataSource.setCache(data)
                emitSource(cacheDataSource.getCache().map { ResultToConsume.Success(it) }.asLiveData())
            } catch (e: Exception) {
                emitSource(cacheDataSource.getCache().map {
                    ResultToConsume.Error(e.message!!, it)
                }.asLiveData())
            }
        }
    }

    override fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>> {
        return liveData {
            try {
                emit(ResultRemoteToConsume.loading())
                require(publisherID != 0) {
                    "id passed from main is 0"
                }
                val data = remoteDataSource.getDetailPublisher(publisherID)
                checkNotNull(data)
                emit(ResultRemoteToConsume.success(data))
            } catch (e: Exception) {
                emit(ResultRemoteToConsume.error(e.message!!))
            }
        }
    }
}
