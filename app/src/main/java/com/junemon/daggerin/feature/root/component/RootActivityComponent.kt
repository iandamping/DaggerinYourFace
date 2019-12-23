package com.junemon.daggerin.feature.root.component

import com.junemon.daggerin.di.component.FragmentSubComponent
import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.feature.detail.game.view.component.GameDetailActivityComponent
import com.junemon.daggerin.feature.detail.publisher.component.PublisherDetailFragmentComponent
import com.junemon.daggerin.feature.main.component.MainFragmentComponent
import com.junemon.daggerin.feature.main.module.GameFragmentModule
import com.junemon.daggerin.feature.main.view.GameFragment
import com.junemon.daggerin.feature.main.view.GameView
import com.junemon.daggerin.feature.publisher.component.PublisherFragmentComponent
import com.junemon.daggerin.feature.publisher.module.PublisherFragmentModule
import com.junemon.daggerin.feature.publisher.view.PublisherFragment
import com.junemon.daggerin.feature.root.RootActivity
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivities
@Subcomponent(modules = [FragmentSubComponent::class])
interface RootActivityComponent {

    fun inject(activity: RootActivity)

    fun getGamesComponent(): MainFragmentComponent.Factory

    fun getPublisherComponent(): PublisherFragmentComponent.Factory

    fun getPublisherDetailComponent():PublisherDetailFragmentComponent.Factory

    fun getGameDetailComponent():GameDetailActivityComponent.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(): RootActivityComponent
    }


}