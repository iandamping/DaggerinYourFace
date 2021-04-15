package com.junemon.daggerin.di.injector

import androidx.fragment.app.FragmentActivity
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.di.component.AppsComponent


/**
 * Created by Ian Damping on 15,April,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
fun FragmentActivity.inject(): AppsComponent = (application as MainApplication).appComponent