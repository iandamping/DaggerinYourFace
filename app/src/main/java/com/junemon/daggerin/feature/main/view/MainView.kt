package com.junemon.daggerin.feature.main.view

import com.junemon.daggerin.model.GamesEntity

interface MainView{
    fun observeData(data:List<GamesEntity>)
    fun observeFailed(throws:Throwable)
}