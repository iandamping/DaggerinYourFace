package com.junemon.daggerin.presentation.vm

import androidx.lifecycle.LiveData
import com.junemon.daggerin.base.BaseViewModel
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.domain.model.GameData
import com.junemon.daggerin.domain.model.GamesDetailData
import com.junemon.daggerin.domain.usecase.GameUseCase
import javax.inject.Inject

class GamePresentationViewModel @Inject constructor(private val repository: GameUseCase) :
    BaseViewModel() {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>> = repository.getCache()

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>> =
        repository.getDetailRemote(gameId)
}
