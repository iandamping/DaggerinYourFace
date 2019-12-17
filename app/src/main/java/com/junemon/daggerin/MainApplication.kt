package com.junemon.daggerin

import android.app.Application
import com.junemon.daggerin.di.component.DaggerAppsComponent
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber

class MainApplication : Application() {
    private val TAG = "MainApplication"
    object appComponent{
        val component by lazy {
            DaggerAppsComponent.create()
        }
    }
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}