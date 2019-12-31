package com.junemon.daggerinyourface.di.component

import android.app.Application
import com.junemon.daggerinyourface.cache.di.DatabaseModule
import com.junemon.daggerinyourface.data.di.RepositoryDataModule
import com.junemon.daggerinyourface.di.scope.ApplicationScope
import com.junemon.daggerinyourface.domain.di.RepositoryDomainModule
import com.junemon.daggerinyourface.network.di.NetworkModule
import com.junemon.daggerinyourface.presentation.di.module.RepositoryPresentationModule
import com.junemon.daggerinyourface.view.root.component.RootActivityComponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        RepositoryDataModule::class,
        RepositoryPresentationModule::class,
        RepositoryDomainModule::class,
        AppSubComponent::class]
)
interface AppsComponent {

    /* Cara subcomponent yang baru ada di MainActivityComponent
    *
    * kenapa kita injectApplication agar kita bisa mendapatkan application & init database module */

    fun getRootActivityComponent(): RootActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun injectApplication(@BindsInstance application: Application): AppsComponent
    }
}
