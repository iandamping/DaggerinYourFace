package com.junemon.daggerin.dagger

import com.junemon.daggerin.monster.Dragon
import com.junemon.daggerin.monster.Goblin
import com.junemon.daggerin.monster.Monster
import dagger.Binds
import dagger.Module

/**
 * Created by Ian Damping on 24,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Module
abstract class MonsterModule {

    @Binds
    abstract fun bindsDragon(dragon: Dragon): Monster

    @Binds
    abstract fun bindsGoblin(goblin: Goblin): Monster
}