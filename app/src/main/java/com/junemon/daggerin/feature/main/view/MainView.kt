package com.junemon.daggerin.feature.main.view

import com.junemon.daggerin.base.adapter.BaseView
import com.junemon.daggerin.db.game.GameDbEntity

interface MainView:BaseView {
    fun observeData(data: List<GameDbEntity>)
    fun observeFailed(throws: Throwable)
}