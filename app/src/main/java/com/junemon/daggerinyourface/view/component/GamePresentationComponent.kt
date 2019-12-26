package com.junemon.daggerinyourface.view.component

import com.junemon.daggerinyourface.di.module.GamePresentationModule
import com.junemon.daggerinyourface.view.game.detail.GameDetailFragment
import com.junemon.daggerinyourface.view.game.GameFragment
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
