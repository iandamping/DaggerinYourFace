package com.junemon.daggerin.di.module

import android.app.Activity
import com.junemon.daggerin.feature.main.view.MainActivity
import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
object ActivityModule {

    @Provides
    fun bindMainActivity(activity: Activity): MainActivity {
        return activity as MainActivity
    }

    @Provides
    fun bindPublisherActivity(activity: Activity): PublisherActivity {
        return activity as PublisherActivity
    }
}