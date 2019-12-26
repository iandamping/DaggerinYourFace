package com.junemon.daggerinyourface.domain.usecase

import androidx.lifecycle.LiveData
import com.junemon.daggerinyourface.domain.model.GameData
import com.junemon.daggerinyourface.domain.model.GamesDetailData
import com.junemon.daggerinyourface.domain.model.ResultRemoteToConsume
import com.junemon.daggerinyourface.domain.model.ResultToConsume
import com.junemon.daggerinyourface.domain.repository.GameRepository
import javax.inject.Inject

class GameUseCase @Inject constructor(private val repository: GameRepository) {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>> = repository.getCache()

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>> =
        repository.getDetailRemote(gameId)
}
