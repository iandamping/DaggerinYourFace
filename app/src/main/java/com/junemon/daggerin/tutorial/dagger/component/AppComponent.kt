package com.junemon.daggerin.tutorial.dagger.component

import com.junemon.daggerin.tutorial.dagger.module.DieselEngineModule
import com.junemon.daggerin.tutorial.dagger.module.DriverModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DriverModule::class])
interface AppComponent {
    /*ini bisa dipakai sebagai database / retrofit instance
    *
    * karena kita menggunakan subcomponent object ini kita delete dulu*/
//    fun getDriver():Driver

    /*Disini kita pass module nya yang tidak abstract dan tidak memiliki default constructor
    * dan ini dinamakan factory method*/
    fun getActivityComponent(dieselEngineModule: DieselEngineModule):ActivityComponent
}