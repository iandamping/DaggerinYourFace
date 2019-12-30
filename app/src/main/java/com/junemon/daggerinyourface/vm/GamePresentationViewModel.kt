package com.junemon.daggerinyourface.presentation.vm

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.junemon.daggerinyourface.base.BaseViewModel
import com.junemon.daggerinyourface.domain.usecase.GameUseCase
import com.junemon.daggerinyourface.model.domain.ResultRemoteToConsume
import com.junemon.daggerinyourface.model.domain.ResultToConsume
import com.junemon.daggerinyourface.model.domain.game.GameData
import com.junemon.daggerinyourface.model.domain.game.GamePagingData
import com.junemon.daggerinyourface.model.domain.game.GamesDetailData
import javax.inject.Inject

class GamePresentationViewModel @Inject constructor(private val repository: GameUseCase) :
    BaseViewModel() {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>> = repository.getCache()

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>> =
        repository.getDetailRemote(gameId)

    fun getPaginationCache(): LiveData<PagedList<GamePagingData>> = repository.getPaginationCache()
}
