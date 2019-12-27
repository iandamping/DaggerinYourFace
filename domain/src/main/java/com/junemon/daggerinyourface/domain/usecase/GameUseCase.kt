package com.junemon.daggerinyourface.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.junemon.daggerinyourface.domain.model.*
import com.junemon.daggerinyourface.domain.repository.GameRepository
import javax.inject.Inject

class GameUseCase @Inject constructor(private val repository: GameRepository) {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>> = repository.getCache()

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>> =
        repository.getDetailRemote(gameId)

    fun getPaginationCache(): LiveData<PagedList<GamePagingData>> = repository.getPaginationCache()
}
