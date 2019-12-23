package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.detail.game.view.component.GameDetailFragmentComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailFragmentComponent
import com.junemon.daggerin.feature.game.component.GameFragmentComponent
import com.junemon.daggerin.feature.publisher.component.PublisherFragmentComponent
import dagger.Module

@Module(subcomponents = [GameFragmentComponent::class, PublisherFragmentComponent::class,
    GameDetailFragmentComponent::class,PublisherDetailFragmentComponent::class])
class FragmentSubComponent
