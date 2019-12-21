package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.main.component.MainFragmentComponent
import com.junemon.daggerin.feature.publisher.component.PublisherFragmentComponent
import dagger.Module

@Module( subcomponents = [MainFragmentComponent::class, PublisherFragmentComponent::class])
class FragmentSubComponent