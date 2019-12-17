package com.junemon.daggerin.di.component

import com.junemon.daggerin.di.module.MainPresenterModule
import com.junemon.daggerin.main.MainActivity
import com.junemon.daggerin.main.MainPresenter
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
import dagger.Component
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
@Subcomponent(modules = [MainPresenterModule::class])
interface ActivityComponent {

    fun getMainPresenter():MainPresenter

    fun inject(activity: MainActivity)

}
