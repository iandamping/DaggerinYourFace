package com.junemon.daggerin.feature.detail.game.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.databinding.ActivityDetailGameBinding
import com.junemon.daggerin.feature.root.RootActivity
import com.junemon.daggerin.model.game.GamesDetailEntity
import com.junemon.daggerin.util.Constant.intentGamesDetailKey
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import javax.inject.Inject

class GameDetailFragment:Fragment(),
    GameDetailView {

    private val detailID by lazy { GameDetailFragmentArgs.fromBundle(arguments!!).gameID }
    private lateinit var binding:ActivityDetailGameBinding

    @Inject lateinit var presenter: GameDetailPresenter

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent
            .getGameDetailComponent().inject(this).injectFragment(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.activity_detail_game,container,false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }
        presenter.apply {
            attachLifecycle(this@GameDetailFragment)
            getData(detailID)
        }
        return binding.root
    }
   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_game)
        presenter.apply {
            attachLifecycle(this@GameDetailFragment)
            getData(detailID)
        }

    }*/



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
}