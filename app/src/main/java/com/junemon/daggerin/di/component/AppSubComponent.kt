package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.detail.game.view.component.GameDetailActivityComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailActivityComponent
import com.junemon.daggerin.feature.game.component.GameActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import dagger.Module

@Module(
    subcomponents = [GameActivityComponent::class, PublisherActivityComponent::class,
        GameDetailActivityComponent::class, PublisherDetailActivityComponent::class]
)
class AppSubComponent
