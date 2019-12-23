package com.junemon.daggerin.feature.root.component

import com.junemon.daggerin.di.component.FragmentSubComponent
import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.feature.detail.game.view.component.GameDetailFragmentComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailFragmentComponent
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailFragment
import com.junemon.daggerin.feature.game.component.GameFragmentComponent
import com.junemon.daggerin.feature.publisher.component.PublisherFragmentComponent
import com.junemon.daggerin.feature.root.RootActivity
import dagger.Subcomponent

@PerActivities
@Subcomponent(modules = [FragmentSubComponent::class])
interface RootActivityComponent {

    fun inject(activity: RootActivity)

    fun getGamesComponent(): GameFragmentComponent.Factory

    fun getPublisherComponent(): PublisherFragmentComponent.Factory

    fun getGamesDetailComponent():GameDetailFragmentComponent.Factory

    fun getPublisherDetailComponent(): PublisherDetailFragmentComponent.Factory


    @Subcomponent.Factory
    interface Factory {
        fun create(): RootActivityComponent
    }
}
