package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.detail.game.view.component.GameDetailActivityComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailFragmentComponent
import com.junemon.daggerin.feature.main.component.MainFragmentComponent
import com.junemon.daggerin.feature.publisher.component.PublisherFragmentComponent
import dagger.Module

@Module(
    subcomponents = [MainFragmentComponent::class, PublisherFragmentComponent::class,
        GameDetailActivityComponent::class, PublisherDetailFragmentComponent::class]
)
class FragmentSubComponent