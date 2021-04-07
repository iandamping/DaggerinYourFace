package com.junemon.daggerin.feature.main.view

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.R
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.di.injector.activityComponent
import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.feature.main.model.MainActivityViewModel
import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import com.junemon.daggerin.model.GameCallback
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import com.junemon.daggerin.util.layoutInflater
import kotlinx.android.synthetic.main.item_games.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    MainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var alert: AlertDialog


    private fun daggerInjection() {
        activityComponent().getMainActivityComponent().provideView(this).inject(this)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        daggerInjection()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setBaseDialog(this)
        presenter.attachLifecycle(this@MainActivity)
        lifecycleScope.launch {
            presenter.fetchData().collect(::render)
        }
    }

    override fun render(state: MainActivityViewModel<List<GameDbEntity>>) {
        when (state) {
            MainActivityViewModel.Complete -> setDialogShow(true)

            MainActivityViewModel.EmptyItem -> if (::binding.isInitialized) Snackbar.make(
                binding.mainRootLayout,
                "empty",
                Snackbar.LENGTH_SHORT
            ).show()
            is MainActivityViewModel.Error -> {
                if (::binding.isInitialized) Snackbar.make(
                    binding.mainRootLayout,
                    state.message,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            MainActivityViewModel.Loading -> setDialogShow(false)
            is MainActivityViewModel.Result -> {
                if (::binding.isInitialized) {
                    binding.apply {
                        recyclerHelper.run {
                            rvMain.setUpVerticalListAdapter(items = state.data,
                                diffUtil = GameCallback.gamesDiffCallbacks,
                                layoutResId = R.layout.item_games,
                                bindHolder = {
                                    tvText.text = it.gameName
                                    loadImageHelper.run {
                                        ivImages.loadWithGlide(it.gameImage)
                                    }
                                }, itemClick = {
                                    val intent by lazy {
                                        Intent(
                                            this@MainActivity,
                                            PublisherActivity::class.java
                                        )
                                    }
                                    startActivity(intent)
                                })
                        }

                    }
                }
            }
        }
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

    private fun setDialogShow(status: Boolean) {
        if (status) {
            alert.dismiss()
        } else {
            alert.show()
        }
    }

}
