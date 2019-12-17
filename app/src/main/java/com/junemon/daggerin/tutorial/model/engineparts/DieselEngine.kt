package com.junemon.daggerin.tutorial.model.engineparts

import android.util.Log
import com.junemon.daggerin.tutorial.model.Engine
import javax.inject.Inject

/*Kalau kita hanya menggunakan interface nya, jangan lupa class yang create interface tersebut tetap di inject*/
/*Ini contoh untuk inject constructor at runtime*/
class DieselEngine @Inject constructor(private val horsePower:Int) :Engine {
    private  val TAG = "DieselEngine"
    override fun startEngine() {
        Log.d(TAG, "startEngine: Diesl engine started with Horsepower $horsePower")
    }
}