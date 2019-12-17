package com.junemon.daggerin.feature.main.component

import com.junemon.daggerin.feature.main.module.MainActivityModule
import com.junemon.daggerin.feature.main.view.MainActivity
import com.junemon.daggerin.feature.main.view.MainPresenter
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
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

    fun getMainPresenter(): MainPresenter

    fun inject(activity: MainActivity)

}
