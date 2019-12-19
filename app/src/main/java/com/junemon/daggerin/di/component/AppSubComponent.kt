package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.main.module.MainActivityModule
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import com.junemon.daggerin.feature.publisher.module.PublisherActivityModule
import dagger.Module

@Module(subcomponents = [MainActivityComponent::class])
class AppSubComponent