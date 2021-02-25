package com.junemon.daggerin.monster

import javax.inject.Inject


/**
 * Created by Ian Damping on 25,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
class MyMonster @Inject constructor(private val monster: Monster) {

    fun summonMyMonster(): String = "My monster is ${monster.getMonsterName()}"
}