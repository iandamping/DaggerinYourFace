package com.junemon.daggerin.di.component

import android.app.Application
import com.junemon.daggerin.di.module.AppsModule
import com.junemon.daggerin.di.module.MainPresenterModule
import com.junemon.daggerin.di.module.NetworkModule
import com.junemon.daggerin.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [AppsModule::class,NetworkModule::class])
interface AppsComponent {

    //kalau module kita punya constructor createnya pake ini
    fun getActivityComponent(mainPresenterModule: MainPresenterModule):ActivityComponent

    /*@Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppsComponent
    }*/

}