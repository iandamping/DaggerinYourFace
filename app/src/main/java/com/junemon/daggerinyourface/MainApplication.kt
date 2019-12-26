package com.junemon.daggerinyourface

import android.app.Application
import com.junemon.daggerinyourface.di.component.AppsComponent
import com.junemon.daggerinyourface.di.component.DaggerAppsComponent
import timber.log.Timber

open class MainApplication : Application() {

    val appComponent: AppsComponent by lazy {
        initializeComponent()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    open fun initializeComponent(): AppsComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the application that will be used as Context in the graph
        return DaggerAppsComponent.factory().injectApplication(this)
    }
}
