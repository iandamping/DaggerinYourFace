package com.junemon.daggerin.tutorial.model.wheelspart

import android.util.Log
import javax.inject.Inject

class Tires @Inject constructor() {
    private val TAG = "Tires"

    fun inflateTires(){
        Log.d(TAG, "inflateTires: Tires inflated")
    }
}