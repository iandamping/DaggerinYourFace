package com.junemon.daggerinyourface.domain.repository

import androidx.lifecycle.LiveData
import com.junemon.daggerinyourface.domain.model.GameData
import com.junemon.daggerinyourface.domain.model.GamesDetailData
import com.junemon.daggerinyourface.domain.model.ResultRemoteToConsume
import com.junemon.daggerinyourface.domain.model.ResultToConsume

interface GameRepository {

    fun getCache(): LiveData<ResultToConsume<List<GameData>>>

    fun getDetailRemote(gameId: Int): LiveData<ResultRemoteToConsume<GamesDetailData>>
}
