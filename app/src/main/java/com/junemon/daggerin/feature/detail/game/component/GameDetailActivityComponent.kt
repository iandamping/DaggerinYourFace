package com.junemon.daggerin.feature.detail.game.component

import com.junemon.daggerin.feature.detail.game.view.GameDetailActivity
import com.junemon.daggerin.feature.detail.game.view.GameDetailView
import dagger.BindsInstance
import dagger.Subcomponent


@Subcomponent
interface GameDetailActivityComponent {

    fun injectActivity(activity: GameDetailActivity)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance gameDetailView: GameDetailView): GameDetailActivityComponent
    }
}