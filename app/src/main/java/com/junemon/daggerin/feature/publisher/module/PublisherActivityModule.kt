package com.junemon.daggerin.feature.publisher.module

import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import com.junemon.daggerin.feature.publisher.view.PublisherView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface PublisherActivityModule {

    @Binds
    fun bindPublisherView(activity: PublisherActivity): PublisherView
}