package com.junemon.daggerin.feature.game.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseActivity
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.feature.detail.game.view.GameDetailActivity
import com.junemon.daggerin.model.game.GameCallback
import com.junemon.daggerin.model.state.Results
import com.junemon.daggerin.util.Constant.intentGamesDetailKey
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import javax.inject.Inject
import kotlinx.android.synthetic.main.item_games.view.*

class GameActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val gameViewModel: GameViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private fun daggerInjection() {
        (application as MainApplication)
            .appComponent.getGameActivityComponent().create().injectActivity(this)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        daggerInjection()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        observeData()
    }

    private fun observeData() {
        gameViewModel.getData().observe(this) {
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

    private fun ActivityMainBinding.consumeData(result: List<GameDbEntity>) {
        with(recyclerHelper) {
            rvMain.setUpVerticalListAdapter(items = result,
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
                            this@GameActivity,
                            GameDetailActivity::class.java
                        )
                    }
                    intent.putExtra(intentGamesDetailKey, gameId)
                    startActivity(intent)
                })
        }
    }
}
