package com.junemon.daggerinyourface.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {

    protected fun timberLogE(msg: String?) {
        Timber.tag("#### timber logger ####").e(msg)
    }

    protected fun timberLogD(msg: String?) {
        Timber.tag("#### timber logger ####").d(msg)
    }

    protected fun timberLogI(msg: String?) {
        Timber.tag("#### timber logger ####").i(msg)
    }

    protected fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        timberLogE(e.message)
    }
}
