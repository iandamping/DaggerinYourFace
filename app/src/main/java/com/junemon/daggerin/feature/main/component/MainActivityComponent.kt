package com.junemon.daggerin.feature.main.component

import com.junemon.daggerin.feature.main.view.MainActivity
import com.junemon.daggerin.feature.main.view.MainView
import dagger.BindsInstance
import dagger.Subcomponent


@Subcomponent
interface MainActivityComponent {

    fun injectActivity(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance mainView: MainView): MainActivityComponent
    }

}
