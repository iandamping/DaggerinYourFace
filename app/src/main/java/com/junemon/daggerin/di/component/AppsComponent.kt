package com.junemon.daggerin.di.component

import android.app.Application
import com.junemon.daggerin.data.di.module.*
import com.junemon.daggerin.di.module.*
import com.junemon.daggerin.di.scope.ApplicationScope
import com.junemon.daggerin.presentation.di.module.LoadImageHelperModule
import com.junemon.daggerin.presentation.di.module.RecyclerHelperModule
import com.junemon.daggerin.domain.di.RepositoryDomainModule
import com.junemon.daggerin.view.root.component.RootActivityComponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        RetrofitHelperModule::class,
        DatabaseHelperModule::class,
        RepositoryDataModule::class,
        RecyclerHelperModule::class,
        LoadImageHelperModule::class,
        RepositoryDomainModule::class,
        ViewModelModule::class,
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
