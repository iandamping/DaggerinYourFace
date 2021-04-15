package com.junemon.daggerin.feature.detail.game.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseActivity
import com.junemon.daggerin.databinding.ActivityDetailGameBinding
import com.junemon.daggerin.model.game.GamesDetailEntity
import com.junemon.daggerin.model.state.Results
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
        super.onCreate(savedInstanceState)
        daggerInjection()
        val detailID by lazy { intent.getIntExtra(intentGamesDetailKey, 0) }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_game)
        observeData(detailID)
    }

    private fun observeData(detailID: Int) {
        viewModel.getData(detailID).observe(this) {
            when (it) {
                is Results.Error -> {
                    setDialogShow(true)
                    Snackbar.make(
                        binding.root,
                        it.message,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                Results.Loading -> setDialogShow(false)
                is Results.Success -> {
                    setDialogShow(true)
                    binding.consumeData(it.data)
                }
            }
        }

    }

    private fun ActivityDetailGameBinding.consumeData(result: GamesDetailEntity) {
        tvDesc.text = result.gameDescription
        tvName.text = result.gameName
        loadImageHelper.run {
            ivImagesDetail.loadWithGlide(result.gameImage)
        }
    }
}
