package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.detail.game.view.component.GameDetailActivityComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailActivityComponent
import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import dagger.Module

@Module(
    subcomponents = [MainActivityComponent::class, PublisherActivityComponent::class,
        GameDetailActivityComponent::class, PublisherDetailActivityComponent::class]
)
class AppSubComponent