package com.junemon.daggerin.di.component

import android.app.Application
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.di.module.*
import com.junemon.daggerin.feature.publisher.module.PublisherActivityModule
import com.junemon.daggerin.di.scope.ApplicationScope
import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import com.junemon.daggerin.util.interfaces.CommonHelper
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [
    LoadImageHelperModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    RetrofitHelperModule::class,
    DatabaseHelperModule::class,
    RecyclerHelperModule::class,
    AppSubComponent::class])
interface AppsComponent {

    /* Cara subcomponent yang baru ada di MainActivityComponent
    *
    * kenapa kita injectApplication agar kita bisa mendapatkan application & init database module */

    fun getMainActivityComponent():MainActivityComponent.Factory

    fun getPublisherActivityComponent(publisherActivityModule: PublisherActivityModule): PublisherActivityComponent

    @Component.Factory
    interface Factory {
        fun injectApplication(@BindsInstance application: Application): AppsComponent
    }

}