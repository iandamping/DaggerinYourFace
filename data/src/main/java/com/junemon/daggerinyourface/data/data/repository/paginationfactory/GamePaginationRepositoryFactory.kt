package com.junemon.daggerinyourface.data.data.repository.paginationfactory

import androidx.paging.DataSource
import androidx.paging.PagedList
import com.junemon.daggerinyourface.data.data.datasource.GameCacheDataSource
import com.junemon.daggerinyourface.data.data.datasource.GameRemoteDataSource
import com.junemon.daggerinyourface.data.data.repository.pagination.GamePaginationRepositoryImpl
import com.junemon.daggerinyourface.model.data.database.game.GamePagingDbEntity

class GamePaginationRepositoryFactory(
    private val cacheDataSource: GameCacheDataSource,
    private val remoteDataSource: GameRemoteDataSource
) : DataSource.Factory<Int, GamePagingDbEntity>() {

    override fun create(): DataSource<Int, GamePagingDbEntity> {
        return GamePaginationRepositoryImpl(cacheDataSource, remoteDataSource)
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
