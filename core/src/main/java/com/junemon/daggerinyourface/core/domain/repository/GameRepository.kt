package com.junemon.daggerinyourface.core.domain.repository

import com.junemon.daggerinyourface.core.domain.model.ConsumeResult
import com.junemon.daggerinyourface.core.presentation.model.game.Game
import com.junemon.daggerinyourface.core.presentation.model.game.GamesDetail
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    fun getGame(): Flow<ConsumeResult<List<Game>>>

    fun getDetailGame(gameId: Int): Flow<ConsumeResult<GamesDetail>>

}
