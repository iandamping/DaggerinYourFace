package com.junemon.daggerin.feature.main.component

import com.junemon.daggerin.feature.main.module.GameFragmentModule
import com.junemon.daggerin.feature.main.view.GameFragment
import com.junemon.daggerin.feature.main.view.GameView
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [GameFragmentModule::class])
interface MainFragmentComponent {

    fun inject(fragment: GameFragment)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance gameView: GameView): MainFragmentComponent
    }

}
