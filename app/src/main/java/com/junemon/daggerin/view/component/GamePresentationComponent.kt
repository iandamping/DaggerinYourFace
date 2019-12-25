package com.junemon.daggerin.view.component

import com.junemon.daggerin.di.module.GamePresentationModule
import com.junemon.daggerin.feature.detail.game.view.GameDetailFragment
import com.junemon.daggerin.feature.game.view.GameFragment
import dagger.Subcomponent

@Subcomponent(modules = [GamePresentationModule::class])
interface GamePresentationComponent {

    fun inject(fragment: GameFragment)

    fun inject(fragment: GameDetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GamePresentationComponent
    }
}
