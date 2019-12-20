package com.junemon.daggerin.feature.detail

import com.junemon.daggerin.model.game.GamesDetailEntity

interface GameDetailView {
    fun observeData(data: GamesDetailEntity)
    fun observeFailed(throws: Throwable)
}