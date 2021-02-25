package com.junemon.daggerin.di.injector

import androidx.fragment.app.FragmentActivity
import com.junemon.daggerin.MainApplication

fun FragmentActivity.activityComponent() = (application as MainApplication).provideAppComponent()