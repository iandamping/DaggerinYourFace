package com.junemon.daggerin.view.root.component

import com.junemon.daggerin.di.component.FragmentSubComponent
import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.view.component.GamePresentationComponent
import com.junemon.daggerin.view.component.PublisherPresentationComponent
import com.junemon.daggerin.view.root.RootActivity
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
