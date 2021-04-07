package com.junemon.daggerin.feature.main.view

import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.feature.main.model.MainActivityViewModel
import kotlinx.coroutines.flow.Flow

interface MainView{
    fun render(state:MainActivityViewModel<List<GameDbEntity>>)
}