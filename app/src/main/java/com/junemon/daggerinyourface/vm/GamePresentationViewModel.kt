package com.junemon.daggerinyourface.presentation.vm

import androidx.lifecycle.LiveData
import com.junemon.daggerinyourface.base.BaseViewModel
import com.junemon.daggerinyourface.domain.model.ResultRemoteToConsume
import com.junemon.daggerinyourface.domain.model.ResultToConsume
import com.junemon.daggerinyourface.domain.model.GameData
import com.junemon.daggerinyourface.domain.model.GamesDetailData
import com.junemon.daggerinyourface.domain.usecase.GameUseCase
import javax.inject.Inject

class GamePresentationViewModel @Inject constructor(private val repository: GameUseCase) :
    BaseViewModel() {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>> = repository.getCache()

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>> =
        repository.getDetailRemote(gameId)
}
