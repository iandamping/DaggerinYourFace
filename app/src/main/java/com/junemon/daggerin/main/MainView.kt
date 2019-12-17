package com.junemon.daggerin.main

import com.junemon.daggerin.model.GamesEntity

interface MainView{
    fun observeData(data:List<GamesEntity>)
    fun observeFailed(throws:Throwable)
}