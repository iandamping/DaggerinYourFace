package com.junemon.daggerin.feature.publisher.component

import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import com.junemon.daggerin.feature.publisher.view.PublisherView
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivity
@MainApplicationCoroutineScope
@Subcomponent
interface PublisherActivityComponent {

    fun inject(activity: PublisherActivity)

    @Subcomponent.Factory
    interface Factory {
        fun provideView(@BindsInstance publisherView: PublisherView): PublisherActivityComponent
    }
}