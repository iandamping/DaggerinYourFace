package com.junemon.daggerin.dagger

import com.junemon.daggerin.monster.Dragon
import dagger.Component

/**
 * Created by Ian Damping on 24,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Component
interface DragonComponent {

    fun getDragon(): Dragon

}