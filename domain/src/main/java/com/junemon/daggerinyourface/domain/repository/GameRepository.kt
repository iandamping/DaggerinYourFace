package com.junemon.daggerinyourface.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.junemon.daggerinyourface.domain.model.*

interface GameRepository {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>>

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>>

    fun getPaginationCache(): LiveData<PagedList<GamePagingData>>
}
