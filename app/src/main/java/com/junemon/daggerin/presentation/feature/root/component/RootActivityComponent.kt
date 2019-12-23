package com.junemon.daggerin.presentation.feature.root.component

import com.junemon.daggerin.di.component.FragmentSubComponent
import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.presentation.di.component.GamePresentationComponent
import com.junemon.daggerin.presentation.di.component.PublisherPresentationComponent
import com.junemon.daggerin.presentation.feature.root.RootActivity
import dagger.Subcomponent

@PerActivities
@Subcomponent(modules = [FragmentSubComponent::class])
interface RootActivityComponent {

    fun inject(activity: RootActivity)

    fun getGamesPresentationComponent(): GamePresentationComponent.Factory

    fun getPublisherPresentationComponent(): PublisherPresentationComponent.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(): RootActivityComponent
    }
}
