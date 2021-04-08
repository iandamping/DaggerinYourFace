package com.junemon.daggerin.dagger

import androidx.fragment.app.FragmentActivity
import com.junemon.daggerin.MainApplication


/**
 * Created by Ian Damping on 08,April,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */

fun FragmentActivity.activityComponent() =   (application as MainApplication).provideMonsterComponent()