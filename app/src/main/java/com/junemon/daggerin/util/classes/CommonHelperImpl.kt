package com.junemon.daggerin.util.classes

import com.junemon.daggerin.util.interfaces.CommonHelper
import javax.inject.Inject
import timber.log.Timber

class CommonHelperImpl @Inject constructor() : CommonHelper {

    override fun timberLogE(msg: String?) {
        Timber.tag("#### timber logger ####").e(msg)
    }

    override fun timberLogD(msg: String?) {
        Timber.tag("#### timber logger ####").d(msg)
    }

    override fun timberLogI(msg: String?) {
        Timber.tag("#### timber logger ####").i(msg)
    }
}
