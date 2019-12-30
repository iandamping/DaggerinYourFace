package com.junemon.daggerinyourface.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.junemon.daggerinyourface.model.domain.ResultRemoteToConsume
import com.junemon.daggerinyourface.model.domain.ResultToConsume
import com.junemon.daggerinyourface.model.domain.game.GameData
import com.junemon.daggerinyourface.model.domain.game.GamePagingData
import com.junemon.daggerinyourface.model.domain.game.GamesDetailData

interface GameRepository {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>>

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>>

    fun getPaginationCache(): LiveData<PagedList<GamePagingData>>
}
