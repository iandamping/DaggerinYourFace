package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.detail.component.GameDetailActivityComponent
import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import dagger.Module

@Module(subcomponents = [MainActivityComponent::class, PublisherActivityComponent::class,
GameDetailActivityComponent::class])
class AppSubComponent