package com.junemon.daggerin.attribute

import android.content.Context
import com.junemon.daggerin.R
import javax.inject.Inject

/**
 * Created by Ian Damping on 24,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */

class DragonAttribute @Inject constructor(private val context: Context) {
    // we dont own this class so we can't using @Inject

    fun getDragonName(): String = context.getString(R.string.dragon_name)
}