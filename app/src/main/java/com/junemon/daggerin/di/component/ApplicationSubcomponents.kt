package com.junemon.daggerin.di.component

import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.component.PublisherActivityComponent
import dagger.Module

// This module tells a Component which are its subcomponents
@Module(
    subcomponents = [
        MainActivityComponent::class,
        PublisherActivityComponent::class
    ]
)
class ApplicationSubcomponents
