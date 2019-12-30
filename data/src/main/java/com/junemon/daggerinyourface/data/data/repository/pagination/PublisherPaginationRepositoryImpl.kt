package com.junemon.daggerinyourface.data.data.repository.pagination

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.junemon.daggerinyourface.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerinyourface.data.data.datasource.PublisherRemoteDataSource
import com.junemon.daggerinyourface.model.data.database.publisher.PublisherPagingDbEntity
import com.junemon.daggerinyourface.model.data.dto.publisher.mapToDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PublisherPaginationRepositoryImpl(
    private val cacheDataSource: PublisherCacheDataSource,
    private val remoteDataSource: PublisherRemoteDataSource
) : PageKeyedDataSource<Int, PublisherPagingDbEntity>() {
    private val TAG = "PublisherPaginationRepo"
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, PublisherPagingDbEntity>
    ) {
        fetchData(1) {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, PublisherPagingDbEntity>
    ) {
        val page = params.key
        fetchData(page) {
            callback.onResult(it, page + 1)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, PublisherPagingDbEntity>
    ) {
        val page = params.key
        fetchData(page) {
            callback.onResult(it, page - 1)
        }
    }

    private fun fetchData(page: Int, callback: (List<PublisherPagingDbEntity>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val firstData = remoteDataSource.getPaginationPublisher(page).mapToDatabase()
                checkNotNull(firstData)
                cacheDataSource.setPagingCache(firstData)
                callback(firstData)
            } catch (e: Exception) {
                Log.e(TAG, "fetchData Failed: ${e.message}")
            }
        }
    }
}
