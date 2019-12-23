package com.junemon.daggerin.feature.game.component

import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.feature.game.module.GameActivityModule
import com.junemon.daggerin.feature.game.view.GameActivity
import dagger.Subcomponent

@PerActivities
@Subcomponent(modules = [GameActivityModule::class])
interface GameActivityComponent {

    fun injectActivity(activity: GameActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GameActivityComponent
    }
}
