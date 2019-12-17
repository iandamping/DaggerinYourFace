package com.junemon.daggerin.tutorial.model.engineparts

import android.util.Log
import com.junemon.daggerin.tutorial.model.Engine
import javax.inject.Inject
import javax.inject.Named


/*Kalau kita hanya menggunakan interface nya, jangan lupa class yang create interface tersebut tetap di inject
* We using named anotation to know which is the value we will be using to create PetrolEngine class
* same in CarComponent*/
class PetrolEngine @Inject constructor(@Named("Horse Power")private val horsePower:Int,
                                       @Named("Engine Capacity")private val engineCapacity:Int):Engine {
    private val TAG = "PetrolEngine"
    override fun startEngine() {
        Log.d(TAG, "startEngine: Petrol engine started with Horsepower $horsePower ")
        Log.d(TAG, "engineCapacity : engine capacity $engineCapacity ")
    }
}