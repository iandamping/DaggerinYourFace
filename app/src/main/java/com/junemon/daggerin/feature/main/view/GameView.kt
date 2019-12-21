package com.junemon.daggerin.feature.main.view

import com.junemon.daggerin.db.game.GameDbEntity

interface GameView {
    fun observeData(data: List<GameDbEntity>)
    fun observeFailed(throws: Throwable)
}