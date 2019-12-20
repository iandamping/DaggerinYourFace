package com.junemon.daggerin.feature.main.component

import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.feature.main.module.MainActivityModule
import com.junemon.daggerin.feature.main.view.MainActivity
import com.junemon.daggerin.feature.main.view.MainView
import dagger.BindsInstance
import dagger.Subcomponent

/*@PerActivity
@Subcomponent(dependencies = [AppsComponent::class],modules = [MainPresenterModule::class])
//ini adalah cara subcomponent dari coding in flow
interface ActivityComponent {

    fun getMainPresenter():MainPresenter

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder{
        fun buildAppComponent(appComponent:AppsComponent):Builder
        fun buildPresenter(mainPresenterModule: MainPresenterModule):Builder
        fun build():ActivityComponent
    }

}*/

@PerActivities
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    /*
    we dont need this function anymore, dagger provide this for us to use
    
    fun getRecyclerHelper(): RecyclerHelper

    fun getLoadImageHelper(): LoadImageHelper

    fun getMainPresenter(): MainPresenter*/

    fun injectActivity(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance mainView: MainView): MainActivityComponent
    }

}
