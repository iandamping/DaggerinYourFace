package com.junemon.daggerin

import android.app.Application
import com.junemon.daggerin.di.component.DaggerAppsComponent
import timber.log.Timber

class MainApplication : Application() {
    private val TAG = "MainApplication"

    object appComponent{
        val applicationComponent by lazy {
            DaggerAppsComponent.create()
        }
        val commonHelper by lazy {
            DaggerAppsComponent.create().getCommonHelper()
        }
        val retrofitHelper by lazy {
            DaggerAppsComponent.create().getRetrofitHelper()
        }
    }
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}