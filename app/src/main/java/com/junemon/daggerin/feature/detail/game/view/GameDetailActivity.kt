package com.junemon.daggerin.feature.detail.game.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseActivity
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.databinding.ActivityDetailGameBinding
import com.junemon.daggerin.util.Constant.intentGamesDetailKey
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import javax.inject.Inject

class GameDetailActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: ActivityDetailGameBinding

    private val viewModel: GameDetailViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private fun daggerInjection() {
        (application as MainApplication)
            .appComponent.getGamesDetailActivityComponent().create().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjection()
        super.onCreate(savedInstanceState)
        val detailID by lazy { intent.getIntExtra(intentGamesDetailKey, 0) }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_game)
        binding.apply {
            lifecycleOwner = this@GameDetailActivity
            observeData(detailID)
        }
    }

    fun ActivityDetailGameBinding.observeData(detailID: Int) {
        apply {
            viewModel.getData(detailID).observe(this@GameDetailActivity, Observer { result ->
                when (result.status) {
                    ResultRemoteToConsume.Status.ERROR -> {
                        setDialogShow(true)
                        Snackbar.make(
                            mainRootLayout,
                            result.message!!,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    ResultRemoteToConsume.Status.SUCCESS -> {
                        setDialogShow(true)
                    }
                    else -> {
                        setDialogShow(false)
                    }
                }
                tvDesc.text = result.data?.gameDescription
                tvName.text = result.data?.gameName
                loadImageHelper.run {
                    ivImagesDetail.loadWithGlide(result.data?.gameImage)
                }
            })
        }
    }
}
