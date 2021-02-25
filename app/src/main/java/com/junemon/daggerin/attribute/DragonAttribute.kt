package com.junemon.daggerin.attribute

import javax.inject.Inject

/**
 * Created by Ian Damping on 24,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */

class DragonAttribute @Inject constructor() {
    // we dont own this class so we can't using @Inject

    fun getDragonName():String = "Dragon named jojo"
}