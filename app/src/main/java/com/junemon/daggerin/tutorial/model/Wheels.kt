package com.junemon.daggerin.tutorial.model

import com.junemon.daggerin.tutorial.model.wheelspart.Rim
import com.junemon.daggerin.tutorial.model.wheelspart.Tires

class Wheels(private val rim: Rim, private val tires: Tires) {
    //i dont own this class so i cannot inject
}