package com.junemon.daggerin.monster

import com.junemon.daggerin.attribute.GoblinAttribute
import javax.inject.Inject


/**
 * Created by Ian Damping on 25,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
class Goblin @Inject constructor(private val attribute: GoblinAttribute) : Monster {

    override fun getMonsterName(): String {
        return attribute.getGoblinName()
    }
}