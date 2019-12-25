package com.junemon.daggerin.presentation.base

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.Fragment
import com.junemon.daggerin.presentation.R
import com.junemon.daggerin.presentation.layoutInflater

abstract class BaseFragment : Fragment() {
    private lateinit var alert: AlertDialog
    override fun onAttach(context: Context) {
        super.onAttach(context)
        setBaseDialog(context)
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
