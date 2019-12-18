package com.junemon.daggerin.di.component

import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.di.module.CommonHelperModule
import com.junemon.daggerin.di.module.GlideModule
import com.junemon.daggerin.feature.main.module.MainActivityModule
import com.junemon.daggerin.di.module.NetworkModule
import com.junemon.daggerin.di.module.RetrofitHelperModule
import com.junemon.daggerin.feature.publisher.module.PublisherActivityModule
import com.junemon.daggerin.di.scope.ApplicationScope
import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import com.junemon.daggerin.util.interfaces.CommonHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Component

@ApplicationScope
@Component(modules = [CommonHelperModule::class,GlideModule::class, NetworkModule::class,RetrofitHelperModule::class])
interface AppsComponent {

    /* ini adalah cara kita create subcomponent,
    *  yang dimana ActivityComponent merupakan subComponent dari appcomponent
    *  kalau module kita punya constructor cara createnya pake ini */
    fun getMainActivityComponent(mainActivityModule: MainActivityModule): MainActivityComponent

    fun getPublisherActivityComponent(publisherActivityModule: PublisherActivityModule): PublisherActivityComponent

    fun getCommonHelper():CommonHelper

    fun getRetrofitHelper():RetrofitHelper

//    fun getApiInterface():ApiInterface

    /*@Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppsComponent
    }*/

}