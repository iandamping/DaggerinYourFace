package com.junemon.daggerinyourface.data.data.repository.pagination

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.junemon.daggerinyourface.data.data.datasource.GameCacheDataSource
import com.junemon.daggerinyourface.data.data.datasource.GameRemoteDataSource
import com.junemon.daggerinyourface.data.datasource.model.mapToDatabase
import com.junemon.daggerinyourface.data.db.game.paging.GamePagingDbEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GamePaginationRepositoryImpl(
    private val cacheDataSource: GameCacheDataSource,
    private val remoteDataSource: GameRemoteDataSource
) : PageKeyedDataSource<Int, GamePagingDbEntity>() {
    private val TAG = "GamePaginationRepositor"
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GamePagingDbEntity>
    ) {
        fetchData(1) {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GamePagingDbEntity>
    ) {
        val page = params.key
        fetchData(page) {
            callback.onResult(it, page + 1)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GamePagingDbEntity>
    ) {
        val page = params.key
        fetchData(page) {
            callback.onResult(it, page - 1)
        }
    }

    private fun fetchData(page: Int, callback: (List<GamePagingDbEntity>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val firstData = remoteDataSource.getPaginationGame(page).mapToDatabase()
                checkNotNull(firstData)
                cacheDataSource.setPagingCache(firstData)
                callback(firstData)
            } catch (e: Exception) {
                Log.e(TAG, "fetchData Failed: ${e.message}")
            }
        }
    }
}
