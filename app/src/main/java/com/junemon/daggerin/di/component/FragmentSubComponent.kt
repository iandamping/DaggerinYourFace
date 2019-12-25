package com.junemon.daggerin.di.component

import com.junemon.daggerin.view.component.GamePresentationComponent
import com.junemon.daggerin.view.component.PublisherPresentationComponent
import dagger.Module

@Module(subcomponents = [PublisherPresentationComponent::class, GamePresentationComponent::class])
class FragmentSubComponent
