package com.junemon.daggerin.presentation.di.component

import com.junemon.daggerin.feature.detail.game.view.GameDetailFragment
import com.junemon.daggerin.feature.game.view.GameFragment
import com.junemon.daggerin.presentation.di.module.GamePresentationModule
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
