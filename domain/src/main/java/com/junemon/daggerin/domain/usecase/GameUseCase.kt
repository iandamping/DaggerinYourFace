package com.junemon.daggerin.domain.usecase

import androidx.lifecycle.LiveData
import com.junemon.daggerin.domain.model.GameData
import com.junemon.daggerin.domain.model.GamesDetailData
import com.junemon.daggerin.domain.model.ResultRemoteToConsume
import com.junemon.daggerin.domain.model.ResultToConsume
import com.junemon.daggerin.domain.repository.GameRepository
import javax.inject.Inject

class GameUseCase @Inject constructor(private val repository: GameRepository) {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>> = repository.getCache()

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>> =
        repository.getDetailRemote(gameId)
}
