package com.junemon.daggerin.base.adapter

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junemon.daggerin.R
import com.junemon.daggerin.util.layoutInflater


/**
 * Created by Ian Damping on 15,April,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
abstract class BaseActivity: AppCompatActivity() {

    private lateinit var alert: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBaseDialog(this)
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

    fun openDialog(status: Boolean) {
        if (status) {
            alert.dismiss()
        } else {
            alert.show()
        }
    }
}