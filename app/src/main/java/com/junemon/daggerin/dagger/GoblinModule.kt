package com.junemon.daggerin.dagger

import com.junemon.daggerin.attribute.GoblinAttribute
import dagger.Module
import dagger.Provides


/**
 * Created by Ian Damping on 25,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Module
object GoblinModule {

    @Provides
    fun provideGoblinAttribute(): GoblinAttribute = GoblinAttribute()
}