package com.junemon.daggerin.tutorial.dagger.module

import com.junemon.daggerin.tutorial.model.Engine
import com.junemon.daggerin.tutorial.model.engineparts.DieselEngine
import dagger.Module
import dagger.Provides

@Module
 class DieselEngineModule(private val horsePowerPassed:Int) {
    /*Daripada kita langsung menggunakan nilai dari constructor,
    lebih baik kita menggunakan value dari provider,
    dan DieselEngine class mengerti harus menggunakan function ini*/
    @Provides
    fun provideHorsePower():Int{
        return horsePowerPassed
    }

    @Provides
    fun provideEngine(engine: DieselEngine): Engine{
        return engine
    }
}