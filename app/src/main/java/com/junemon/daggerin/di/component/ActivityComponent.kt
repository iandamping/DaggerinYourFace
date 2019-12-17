package com.junemon.daggerin.di.component

import com.junemon.daggerin.di.module.MainPresenterModule
import com.junemon.daggerin.main.MainActivity
import com.junemon.daggerin.main.MainPresenter
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppsComponent::class],modules = [MainPresenterModule::class])
interface ActivityComponent {

    fun getMainPresenter():MainPresenter

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder{
        fun buildAppComponent(appComponent:AppsComponent):Builder
        fun buildPresenter(mainPresenterModule: MainPresenterModule):Builder
        fun build():ActivityComponent
    }

}
