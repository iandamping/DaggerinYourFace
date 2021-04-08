package com.junemon.daggerin.dagger

import com.junemon.daggerin.MainActivity
import com.junemon.daggerin.MainApplication
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Ian Damping on 24,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Component(modules = [AttributeModule::class, MyMonsterModule::class, ContextModule::class])
interface MonsterComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun inject(@BindsInstance application: MainApplication): MonsterComponent
    }

}

