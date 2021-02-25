package com.junemon.daggerin.feature.publisher.component

import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.feature.publisher.module.PublisherActivityModule
import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import com.junemon.daggerin.feature.publisher.view.PublisherPresenter
import com.junemon.daggerin.feature.publisher.view.PublisherView
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivity
@MainApplicationCoroutineScope
@Subcomponent(modules = [PublisherActivityModule::class])
interface PublisherActivityComponent {

    fun inject(activity: PublisherActivity)

    @Subcomponent.Factory
    interface Factory {
        fun provideView(@BindsInstance publisherView: PublisherView): PublisherActivityComponent
    }
}