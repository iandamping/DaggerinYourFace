package com.junemon.daggerin.di.component

import com.junemon.daggerin.di.module.AppsModule
import com.junemon.daggerin.di.module.MainPresenterModule
import com.junemon.daggerin.di.module.NetworkModule
import com.junemon.daggerin.di.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [AppsModule::class, NetworkModule::class])
interface AppsComponent {

    /* ini adalah cara kita create subcomponent,
    *  yang dimana ActivityComponent merupakan subComponent dari appcomponent
    *  kalau module kita punya constructor cara createnya pake ini */
    fun getMainActivityComponent(mainPresenterModule: MainPresenterModule): MainActivityComponent

//    fun getApiInterface():ApiInterface

    /*@Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppsComponent
    }*/

}