package com.junemon.daggerinyourface.view.component

import com.junemon.daggerinyourface.di.module.GamePresentationModule
import com.junemon.daggerinyourface.view.game.GameFragment
import com.junemon.daggerinyourface.view.game.detail.GameDetailFragment
import com.junemon.daggerinyourface.view.game.paging.GamePagingFragment
import dagger.Subcomponent

@Subcomponent(modules = [GamePresentationModule::class])
interface GamePresentationComponent {

    fun inject(fragment: GameFragment)

    fun inject(fragment: GameDetailFragment)

    fun inject(fragment: GamePagingFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GamePresentationComponent
    }
}
