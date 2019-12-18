package com.junemon.daggerin.di.component

import com.junemon.daggerin.di.module.*
import com.junemon.daggerin.feature.main.module.MainActivityModule
import com.junemon.daggerin.feature.publisher.module.PublisherActivityModule
import com.junemon.daggerin.di.scope.ApplicationScope
import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import com.junemon.daggerin.util.interfaces.CommonHelper
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Component

@ApplicationScope
@Component(modules = [CommonHelperModule::class, LoadImageHelperModule::class, NetworkModule::class,
    RetrofitHelperModule::class,RecyclerHelperModule::class])
interface AppsComponent {

    /* ini adalah cara kita create subcomponent,
    *  yang dimana ActivityComponent merupakan subComponent dari appcomponent
    *  kalau module kita punya constructor cara createnya pake ini */
    fun getMainActivityComponent(mainActivityModule: MainActivityModule): MainActivityComponent

    fun getPublisherActivityComponent(publisherActivityModule: PublisherActivityModule): PublisherActivityComponent

    fun getCommonHelper(): CommonHelper

//    fun getRetrofitHelper(): RetrofitHelper


    /*@Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppsComponent
    }*/

}