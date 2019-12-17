package com.junemon.daggerin

import android.app.Application
import com.junemon.daggerin.di.component.DaggerAppsComponent
import timber.log.Timber

class MainApplication : Application() {

    object appComponent{
        val component by lazy {
            DaggerAppsComponent.builder().application(MainApplication()).build()
        }
    }
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}