package com.junemon.daggerin.tutorial

import android.app.Application
import com.junemon.daggerin.tutorial.dagger.component.AppComponent
import com.junemon.daggerin.tutorial.dagger.component.DaggerAppComponent

class DaggerApplication : Application() {

    object DaggerApplications {
        val component: AppComponent by lazy {
            /*crete dagger app component only*/
            DaggerAppComponent.create()
        }

    }
}