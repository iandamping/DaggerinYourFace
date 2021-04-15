package com.junemon.daggerin.feature.detail.game.component

import com.junemon.daggerin.feature.detail.game.view.GameDetailActivity
import com.junemon.daggerin.feature.detail.game.module.GameDetailActivityModule
import dagger.Subcomponent


@Subcomponent(modules = [GameDetailActivityModule::class])
interface GameDetailActivityComponent {

    fun inject(activity: GameDetailActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GameDetailActivityComponent
    }
}
