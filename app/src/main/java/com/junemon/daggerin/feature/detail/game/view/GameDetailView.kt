package com.junemon.daggerin.feature.detail.game.view

import com.junemon.daggerin.base.adapter.BaseView
import com.junemon.daggerin.model.game.GamesDetailEntity

interface GameDetailView: BaseView {
    fun observeData(data: GamesDetailEntity)
    fun observeFailed(throws: Throwable)
}