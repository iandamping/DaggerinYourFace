package com.junemon.daggerin.di.component

import android.app.Application
import com.junemon.daggerin.di.module.*
import com.junemon.daggerin.di.scope.ApplicationScope
import com.junemon.daggerin.feature.detail.game.view.component.GameDetailFragmentComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailFragmentComponent
import com.junemon.daggerin.feature.root.component.RootActivityComponent
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
