package com.junemon.daggerinyourface.data.data.repository.paginationfactory

import androidx.paging.DataSource
import androidx.paging.PagedList
import com.junemon.daggerinyourface.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerinyourface.data.data.datasource.PublisherRemoteDataSource
import com.junemon.daggerinyourface.data.data.repository.pagination.PublisherPaginationRepositoryImpl
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDbEntity

class PublisherPaginationRepositoryFactory(
    private val cacheDataSource: PublisherCacheDataSource,
    private val remoteDataSource: PublisherRemoteDataSource
) : DataSource.Factory<Int, PublisherPagingDbEntity>() {
    override fun create(): DataSource<Int, PublisherPagingDbEntity> {
        return PublisherPaginationRepositoryImpl(cacheDataSource, remoteDataSource)
    }

    companion object {
        private const val PAGE_SIZE = 10

        fun pagedListConfig(): PagedList.Config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()
    }
}
