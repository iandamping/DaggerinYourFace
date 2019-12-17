package com.junemon.daggerin.tutorial.dagger.module

import com.junemon.daggerin.tutorial.model.Engine
import com.junemon.daggerin.tutorial.model.engineparts.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PetrolEngineModule {

    /*Jika menggunakan anotasi binds, sebaiknya jangan berikan dia anotasi singleton melainkan class
    * yang di provide lah yang menggunakan anotasi singleton, dalam contoh ini adalah PetrolEngine class*/
    @Binds
    abstract fun bindsEngine(engine:PetrolEngine):Engine
}