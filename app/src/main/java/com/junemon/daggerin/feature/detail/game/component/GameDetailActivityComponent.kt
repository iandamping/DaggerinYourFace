package com.junemon.daggerin.feature.detail.game.view.component

import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.feature.detail.game.view.GameDetailActivity
import com.junemon.daggerin.feature.detail.game.view.GameDetailView
import com.junemon.daggerin.feature.detail.game.view.module.GameDetailActivityModule
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivities
@Subcomponent(modules = [GameDetailActivityModule::class])
interface GameDetailActivityComponent {

    fun injectActivity(activity: GameDetailActivity)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance gameDetailView: GameDetailView): GameDetailActivityComponent
    }
}