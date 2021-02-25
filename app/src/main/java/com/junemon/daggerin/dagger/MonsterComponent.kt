package com.junemon.daggerin.dagger

import com.junemon.daggerin.monster.MyMonster
import dagger.Component

/**
 * Created by Ian Damping on 24,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Component(modules = [AttributeModule::class, MyMonsterModule::class])
interface MonsterComponent {

    fun getMyMonster(): MyMonster

}