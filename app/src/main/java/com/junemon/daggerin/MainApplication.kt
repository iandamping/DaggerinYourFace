package com.junemon.daggerin

import android.app.Application
import com.junemon.daggerin.di.component.AppsComponent
import com.junemon.daggerin.di.component.AppsComponentProvider
import com.junemon.daggerin.di.component.DaggerAppsComponent
import timber.log.Timber

open class MainApplication : Application(), AppsComponentProvider {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun provideAppComponent(): AppsComponent {
        return DaggerAppsComponent.factory().injectApplication(this)
    }
}