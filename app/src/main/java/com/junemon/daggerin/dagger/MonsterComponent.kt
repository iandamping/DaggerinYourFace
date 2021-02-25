package com.junemon.daggerin.dagger

import com.junemon.daggerin.monster.Dragon
import com.junemon.daggerin.monster.Goblin
import dagger.Component

/**
 * Created by Ian Damping on 24,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Component(modules = [DragonModule::class, GoblinModule::class, MonsterModule::class])
interface MonsterComponent {

    fun getDragon(): Dragon

    fun getGoblin(): Goblin

}