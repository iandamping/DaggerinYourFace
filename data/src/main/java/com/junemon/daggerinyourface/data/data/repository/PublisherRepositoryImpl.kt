package com.junemon.daggerinyourface.data.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.junemon.daggerinyourface.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerinyourface.data.data.datasource.PublisherRemoteDataSource
import com.junemon.daggerinyourface.data.data.repository.paginationfactory.PublisherPaginationRepositoryFactory
import com.junemon.daggerinyourface.cache.util.dto.publisher.mapToDomain
import com.junemon.daggerinyourface.domain.repository.PublisherRepository
import com.junemon.daggerinyourface.model.data.dto.publisher.mapToDomain
import com.junemon.daggerinyourface.model.domain.ResultRemoteToConsume
import com.junemon.daggerinyourface.model.domain.ResultToConsume
import com.junemon.daggerinyourface.model.domain.publisher.PublisherPagingData
import com.junemon.daggerinyourface.model.domain.publisher.PublishersData
import com.junemon.daggerinyourface.model.domain.publisher.PublishersDetailData
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class PublisherRepositoryImpl @Inject constructor(
    private val cacheDataSource: PublisherCacheDataSource,
    private val remoteDataSource: PublisherRemoteDataSource
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
                cacheDataSource.setCache(remoteDataSource.getPublisher().mapToDomain())
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
                emit(ResultRemoteToConsume.success(data.mapToDomain()))
            } catch (e: Exception) {
                emit(ResultRemoteToConsume.error(e.message!!))
            }
        }
    }

    override fun getPaginationCache(): LiveData<PagedList<PublisherPagingData>> {
        val dataSourceFactory = PublisherPaginationRepositoryFactory(cacheDataSource, remoteDataSource).map { it.mapToDomain() }
        return LivePagedListBuilder(dataSourceFactory, PublisherPaginationRepositoryFactory.pagedListConfig()).build()
    }
}
