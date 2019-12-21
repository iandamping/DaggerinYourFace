package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.detail.game.view.component.GameDetailActivityComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailActivityComponent
import dagger.Module

@Module(
    subcomponents = [
        GameDetailActivityComponent::class, PublisherDetailActivityComponent::class]
    , includes = [FragmentSubComponent::class]
)
class AppSubComponent