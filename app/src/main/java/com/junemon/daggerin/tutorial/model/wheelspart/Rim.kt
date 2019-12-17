package com.junemon.daggerin.tutorial.model.wheelspart

import android.util.Log
import javax.inject.Inject

class Rim @Inject constructor() {
    private val TAG = "Rim"

    fun inflateRims(){
        Log.d(TAG, "inflateRims: Rims inflated")
    }
}