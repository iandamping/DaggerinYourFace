package com.junemon.daggerin.di.component

import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.di.module.*
import com.junemon.daggerin.di.scope.ApplicationScope
import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ContextModule::class,
        CoroutinesModule::class,
        CoroutineScopeModule::class,
        LoadImageHelperModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        RetrofitHelperModule::class,
        DatabaseHelperModule::class,
        RecyclerHelperModule::class,
        ApplicationSubcomponents::class]
)
interface AppsComponent {

    /* Cara subcomponent yang baru ada di MainActivityComponent
    *
    * kenapa kita injectApplication agar kita bisa mendapatkan application & init database module */

    fun getMainActivityComponent(): MainActivityComponent.Factory

    fun getPublisherActivityComponent(): PublisherActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun injectApplication(@BindsInstance application: MainApplication): AppsComponent
    }

}

interface AppsComponentProvider {

    fun provideAppComponent(): AppsComponent
}