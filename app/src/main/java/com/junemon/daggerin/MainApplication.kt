package com.junemon.daggerin

import android.app.Application
import com.junemon.daggerin.dagger.DaggerMonsterComponent
import com.junemon.daggerin.dagger.MonsterComponent
import com.junemon.daggerin.dagger.MonsterComponentProvider


/**
 * Created by Ian Damping on 08,April,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
class MainApplication : Application(), MonsterComponentProvider {


    override fun provideMonsterComponent(): MonsterComponent {
        return DaggerMonsterComponent.factory().inject(this)
    }
}