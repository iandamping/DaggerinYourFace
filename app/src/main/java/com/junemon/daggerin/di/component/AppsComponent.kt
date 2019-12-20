package com.junemon.daggerin.di.component

import android.app.Application
import com.junemon.daggerin.di.module.*
import com.junemon.daggerin.di.scope.ApplicationScope
import com.junemon.daggerin.feature.detail.component.GameDetailActivityComponent
import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        LoadImageHelperModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        RetrofitHelperModule::class,
        DatabaseHelperModule::class,
        RecyclerHelperModule::class,
        AppSubComponent::class]
)
interface AppsComponent {

    /* Cara subcomponent yang baru ada di MainActivityComponent
    *
    * kenapa kita injectApplication agar kita bisa mendapatkan application & init database module */

    fun getMainActivityComponent(): MainActivityComponent.Factory

    fun getPublisherActivityComponent(): PublisherActivityComponent.Factory

    fun getGamesDetailActivityComponent():GameDetailActivityComponent.Factory

    /*//Ini adalah cara sub-component dari coding in flow
    fun getPublisherActivityComponent(publisherActivityModule: PublisherActivityModule): PublisherActivityComponent*/

    @Component.Factory
    interface Factory {
        fun injectApplication(@BindsInstance application: Application): AppsComponent
    }

}