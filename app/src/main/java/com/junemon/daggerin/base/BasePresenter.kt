package com.junemon.daggerin.base

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.junemon.daggerin.R
import com.junemon.daggerin.util.layoutInflater
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import timber.log.Timber

abstract class BasePresenter<out View>(private val viewsPassed: View) : LifecycleObserver {
    private val job by lazy { Job() }
    protected var customScope = CoroutineScope(Dispatchers.Main + job + getJobErrorHandler())

    private lateinit var lifecycleOwner: FragmentActivity
    private lateinit var alert: AlertDialog

    fun attachLifecycle(lifeCycleOwner: FragmentActivity) {
        this.lifecycleOwner = lifeCycleOwner
        setBaseDialog(lifeCycleOwner)
        lifeCycleOwner.lifecycle.addObserver(this)
    }

    protected fun timberLogE(msg: String?) {
        Timber.tag("#### timber logger ####").e(msg)
    }

    protected fun timberLogD(msg: String?) {
        Timber.tag("#### timber logger ####").d(msg)
    }

    protected fun timberLogI(msg: String?) {
        Timber.tag("#### timber logger ####").i(msg)
    }

    protected fun view(): View {
        return viewsPassed
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onViewDestroyed() {
        job.cancel()
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        setDialogShow(true)
    }

    private fun setBaseDialog(context: Context) {
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = context.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_loading, null)
        dialogBuilder.setView(dialogView)
        alert = dialogBuilder.create().apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(false)
            setCanceledOnTouchOutside(false)
        }

    }

    protected fun setDialogShow(status: Boolean) {
        if (status) {
            alert.dismiss()
        } else {
            alert.show()
        }
    }
}