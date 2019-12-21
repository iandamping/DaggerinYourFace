package com.junemon.daggerin.feature.main.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.feature.detail.game.view.GameDetailActivity
import com.junemon.daggerin.feature.root.RootActivity
import com.junemon.daggerin.model.game.GameCallback
import com.junemon.daggerin.util.Constant.intentGamesDetailKey
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import kotlinx.android.synthetic.main.item_games.view.*
import javax.inject.Inject

class GameFragment : Fragment(),
    GameView {

    @Inject
    lateinit var presenter: GamePresenter

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent
            .getGamesComponent().inject(this).inject(this)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_main,container,false)
        presenter.apply {
            attachLifecycle(this@GameFragment)
            getData()
        }
        return binding.root
    }


    override fun observeData(data: List<GameDbEntity>) {
        if (::binding.isInitialized) {
            binding.apply {
                recyclerHelper.run {
                    rvMain.setUpVerticalListAdapter(items = data,
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
                                    this@GameFragment.context,
                                    GameDetailActivity::class.java
                                )
                            }
                            intent.putExtra(intentGamesDetailKey,gameId)
                            startActivity(intent)
                        })
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


}
