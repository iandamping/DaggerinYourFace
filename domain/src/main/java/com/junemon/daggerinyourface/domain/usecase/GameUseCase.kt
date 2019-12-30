package com.junemon.daggerinyourface.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.junemon.daggerinyourface.domain.repository.GameRepository
import com.junemon.daggerinyourface.model.domain.ResultRemoteToConsume
import com.junemon.daggerinyourface.model.domain.ResultToConsume
import com.junemon.daggerinyourface.model.domain.game.GameData
import com.junemon.daggerinyourface.model.domain.game.GamePagingData
import com.junemon.daggerinyourface.model.domain.game.GamesDetailData
import javax.inject.Inject

class GameUseCase @Inject constructor(private val repository: GameRepository) {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>> = repository.getCache()

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>> =
        repository.getDetailRemote(gameId)

    fun getPaginationCache(): LiveData<PagedList<GamePagingData>> = repository.getPaginationCache()
}
