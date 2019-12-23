package com.junemon.daggerin.feature.game.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseActivity
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.feature.detail.game.view.GameDetailActivity
import com.junemon.daggerin.model.game.GameCallback
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
        daggerInjection()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@GameActivity
            observeData()
        }
    }

    fun ActivityMainBinding.observeData() {
        apply {
            gameViewModel.getData().observe(this@GameActivity, Observer { result ->
                when (result) {
                    is ResultToConsume.Success -> {
                        setDialogShow(true)
                    }
                    is ResultToConsume.Error -> {
                        setDialogShow(true)
                        Snackbar.make(
                            mainRootLayout,
                            result.message!!,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        setDialogShow(false)
                    }
                }
                consumeData(result)
            })
        }
    }

    private fun ActivityMainBinding.consumeData(result: ResultToConsume<List<GameDbEntity>>) {
        recyclerHelper.run {
            rvMain.setUpVerticalListAdapter(items = result.data,
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
