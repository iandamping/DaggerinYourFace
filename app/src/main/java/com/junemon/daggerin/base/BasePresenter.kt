package com.junemon.daggerin.base

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.ian.app.helper.util.layoutInflater
import com.junemon.daggerin.R
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<out View>(private val viewsPassed:View) : LifecycleObserver{
    private lateinit var lifecycleOwner: FragmentActivity
    private lateinit var alert: AlertDialog
    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    fun attachLifecycle(lifeCycleOwner: FragmentActivity) {
        this.lifecycleOwner = lifeCycleOwner
        setBaseDialog(lifeCycleOwner)
        lifeCycleOwner.lifecycle.addObserver(this)
    }

    protected fun view(): View {
        return viewsPassed
    }

    protected fun getLifeCycleOwner(): FragmentActivity {
        return lifecycleOwner
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onViewDestroyed() {
        compositeDisposable.dispose()
    }

    protected fun setBaseDialog(context: Context) {
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = context.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_loading, null)
        dialogBuilder.setView(dialogView)
        alert = dialogBuilder.create()
        alert.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alert.setCancelable(false)
        alert.setCanceledOnTouchOutside(false)
    }

    protected fun setDialogShow(status: Boolean) {
        if (status) {
            alert.dismiss()
        } else {
           alert.show()
        }
    }
}