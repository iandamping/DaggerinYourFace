package com.junemon.daggerin.di.component

import android.app.Application
import com.junemon.daggerin.di.module.*
import com.junemon.daggerin.di.scope.ApplicationScope
import com.junemon.daggerin.feature.detail.game.component.GameDetailActivityComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailActivityComponent
import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        RetrofitHelperModule::class,
        DatabaseHelperModule::class,
        GlideModule::class,
        LoadImageHelperModule::class,
        RecyclerHelperModule::class,
        AppSubComponent::class]
)
interface AppsComponent {

    fun getMainActivityComponent(): MainActivityComponent.Factory

    fun getPublisherActivityComponent(): PublisherActivityComponent.Factory

    fun getGamesDetailActivityComponent(): GameDetailActivityComponent.Factory

    fun getPublisherDetailActivityComponent():PublisherDetailActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun injectApplication(@BindsInstance application: Application): AppsComponent
    }

}