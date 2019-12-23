package com.junemon.daggerin.feature.detail.game.view.component

import com.junemon.daggerin.feature.detail.game.view.GameDetailFragment
import com.junemon.daggerin.feature.detail.game.view.GameDetailView
import com.junemon.daggerin.feature.detail.game.view.module.GameDetailActivityModule
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [GameDetailActivityModule::class])
interface GameDetailActivityComponent {

    fun injectFragment(fragment: GameDetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance gameDetailView: GameDetailView): GameDetailActivityComponent
    }
}