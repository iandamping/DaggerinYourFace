package com.junemon.daggerin.feature.detail.game.view.component

import com.junemon.daggerin.feature.detail.game.view.GameDetailFragment
import com.junemon.daggerin.feature.detail.game.view.module.GameFragmentDetailModule
import dagger.Subcomponent

@Subcomponent(modules = [GameFragmentDetailModule::class])
interface GameDetailFragmentComponent {

    fun inject(fragment: GameDetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GameDetailFragmentComponent
    }
}
