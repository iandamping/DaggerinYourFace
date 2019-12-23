package com.junemon.daggerin.di.component

import com.junemon.daggerin.presentation.di.component.GamePresentationComponent
import com.junemon.daggerin.presentation.di.component.PublisherPresentationComponent
import dagger.Module

@Module(subcomponents = [PublisherPresentationComponent::class, GamePresentationComponent::class])
class FragmentSubComponent
