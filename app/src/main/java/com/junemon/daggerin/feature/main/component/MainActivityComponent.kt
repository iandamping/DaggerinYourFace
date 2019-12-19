package com.junemon.daggerin.feature.main.component

import com.bumptech.glide.RequestManager
import com.junemon.daggerin.feature.main.module.MainActivityModule
import com.junemon.daggerin.feature.main.view.MainActivity
import com.junemon.daggerin.feature.main.view.MainPresenter
import com.junemon.daggerin.feature.main.view.MainView
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import dagger.BindsInstance
import dagger.Subcomponent

/*@PerActivity
@Subcomponent(dependencies = [AppsComponent::class],modules = [MainPresenterModule::class])
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

@PerActivity
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    /*
    we dont need this function anymore, dagger provide it for us to use
    
    fun getRecyclerHelper(): RecyclerHelper

    fun getLoadImageHelper(): LoadImageHelper

    fun getMainPresenter(): MainPresenter*/

    fun injectActivity(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun injectView(@BindsInstance mainView: MainView): MainActivityComponent
    }

}
