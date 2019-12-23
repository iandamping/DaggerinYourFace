package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.detail.game.view.component.GameDetailActivityComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailFragmentComponent
import dagger.Module

@Module(includes = [FragmentSubComponent::class]
)
class AppSubComponent