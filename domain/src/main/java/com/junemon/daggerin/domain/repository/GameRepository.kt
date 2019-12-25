package com.junemon.daggerin.domain.repository

import androidx.lifecycle.LiveData
import com.junemon.daggerin.domain.model.GameData
import com.junemon.daggerin.domain.model.GamesDetailData
import com.junemon.daggerin.domain.model.ResultRemoteToConsume
import com.junemon.daggerin.domain.model.ResultToConsume

interface GameRepository {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>>

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>>
}
