package com.junemon.daggerin.feature.main.component

import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.feature.main.view.MainActivity
import com.junemon.daggerin.feature.main.view.MainView
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivity
@MainApplicationCoroutineScope
@Subcomponent
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun provideView(@BindsInstance view: MainView): MainActivityComponent
    }

}