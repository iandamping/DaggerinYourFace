package com.junemon.daggerin.tutorial.dagger.module

import com.junemon.daggerin.tutorial.model.Wheels
import com.junemon.daggerin.tutorial.model.wheelspart.Rim
import com.junemon.daggerin.tutorial.model.wheelspart.Tires
import dagger.Module
import dagger.Provides

@Module
object WheelsModule {
    @Provides
    fun provideRims():Rim {
        val rims by lazy { Rim() }
        rims.inflateRims()
        return rims
    }
    @Provides
    fun provideTires():Tires{
        val tires by lazy { Tires() }
        tires.inflateTires()
        return tires
    }
    //untuk bisa mendapatkan wheel kita harus provide Rim class dan Tire Class seperti diatas
    //kalo tidak dagger tidak tau cara create Rim dan Tire Class
    @Provides
    fun provideWheels(rim: Rim,tires: Tires):Wheels{
        return Wheels(rim, tires)
    }
}