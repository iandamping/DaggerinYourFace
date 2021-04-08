package com.junemon.daggerin.dagger

import android.content.Context
import com.junemon.daggerin.attribute.DragonAttribute
import dagger.Module
import dagger.Provides


/**
 * Created by Ian Damping on 25,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Module
object AttributeModule {

    @Provides
    fun provideDragonAttribute(context: Context): DragonAttribute = DragonAttribute(context)
}