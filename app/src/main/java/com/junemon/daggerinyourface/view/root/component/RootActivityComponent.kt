package com.junemon.daggerinyourface.view.root.component

import com.junemon.daggerinyourface.di.component.FragmentSubComponent
import com.junemon.daggerinyourface.di.scope.PerActivities
import com.junemon.daggerinyourface.view.component.GamePresentationComponent
import com.junemon.daggerinyourface.view.component.PublisherPresentationComponent
import com.junemon.daggerinyourface.view.root.RootActivity
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
