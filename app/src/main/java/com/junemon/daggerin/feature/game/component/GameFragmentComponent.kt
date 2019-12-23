package com.junemon.daggerin.feature.game.component

import com.junemon.daggerin.feature.game.module.GameFragmentModule
import com.junemon.daggerin.feature.game.view.GameFragment
import dagger.Subcomponent

@Subcomponent(modules = [GameFragmentModule::class])
interface GameFragmentComponent {

    fun inject(fragment: GameFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GameFragmentComponent
    }
}
