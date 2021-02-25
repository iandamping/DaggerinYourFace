package com.junemon.daggerin.monster

import com.junemon.daggerin.attribute.DragonAttribute
import javax.inject.Inject

/**
 * Created by Ian Damping on 24,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
class Dragon @Inject constructor(private val attribute: DragonAttribute) : Monster {

    override fun getMonsterName(): String {
        return attribute.getDragonName()
    }
}