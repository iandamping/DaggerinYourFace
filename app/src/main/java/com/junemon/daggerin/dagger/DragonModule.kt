package com.junemon.daggerin.dagger

import com.junemon.daggerin.attribute.DragonAttribute
import dagger.Module
import dagger.Provides

/**
 * Created by Ian Damping on 24,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Module
object DragonModule {

    @Provides
    fun provideDragonAttribute(): DragonAttribute = DragonAttribute()
}