package com.junemon.daggerin.feature.detail.game.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseActivity
import com.junemon.daggerin.databinding.ActivityDetailGameBinding
import com.junemon.daggerin.di.injector.inject
import com.junemon.daggerin.model.game.GamesDetailEntity
import com.junemon.daggerin.util.Constant.intentGamesDetailKey
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import javax.inject.Inject

class GameDetailActivity: BaseActivity(),
    GameDetailView {

    private val detailID by lazy { intent.getIntExtra(intentGamesDetailKey,0) }
    private lateinit var binding:ActivityDetailGameBinding

    @Inject lateinit var presenter: GameDetailPresenter

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private fun daggerInjection() {
        inject().getGamesDetailActivityComponent().inject(this).injectActivity(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjection()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_game)
        lifecycleScope.launchWhenStarted {
            presenter.getData(detailID)
        }
    }



    override fun observeData(data: GamesDetailEntity) {
        if (::binding.isInitialized){
            binding.apply {
                tvDesc.text = data.gameDescription
                tvName.text = data.gameName
                loadImageHelper.run {
                    ivImagesDetail.loadWithGlide(data.gameImage)
                }
            }
        }
    }

    override fun observeFailed(throws: Throwable) {
        if (::binding.isInitialized) Snackbar.make(
            binding.mainRootLayout,
            throws.localizedMessage,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun setDialogShow(data: Boolean) {
        openDialog(data)
    }
}