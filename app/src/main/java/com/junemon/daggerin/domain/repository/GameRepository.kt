package com.junemon.daggerin.domain.repository

import androidx.lifecycle.LiveData
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.domain.model.GameData
import com.junemon.daggerin.domain.model.GamesDetailData

interface GameRepository {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>>

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>>
}
