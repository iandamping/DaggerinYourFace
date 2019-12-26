package com.junemon.daggerinyourface.di.component

import com.junemon.daggerinyourface.view.component.GamePresentationComponent
import com.junemon.daggerinyourface.view.component.PublisherPresentationComponent
import dagger.Module

@Module(subcomponents = [PublisherPresentationComponent::class, GamePresentationComponent::class])
class FragmentSubComponent
