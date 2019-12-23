package com.junemon.daggerin.feature.game.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseFragment
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.data.datasource.model.GameCallback
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.presentation.feature.root.RootActivity
import com.junemon.daggerin.presentation.model.GamePresentation
import com.junemon.daggerin.presentation.model.mapToPresentation
import com.junemon.daggerin.presentation.vm.GamePresentationViewModel
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import javax.inject.Inject
import kotlinx.android.synthetic.main.item_games.view.*

class GameFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val gameViewModel: GamePresentationViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_main, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            observeData()
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent
            .getGamesPresentationComponent().create().inject(this)
    }

    fun ActivityMainBinding.observeData() {
        apply {
            gameViewModel.getCache().observe(viewLifecycleOwner, Observer { result ->
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
                consumeData(result.data?.mapToPresentation())
            })
        }
    }

    private fun ActivityMainBinding.consumeData(result: List<GamePresentation>?) {
        recyclerHelper.run {
            rvMain.setUpVerticalListAdapter(items = result,
                diffUtil = GameCallback.gamesDiffCallbacks,
                layoutResId = R.layout.item_games,
                bindHolder = {
                    tvText.text = it.gameName
                    loadImageHelper.run {
                        ivImages.loadWithGlide(it.gameImage)
                    }
                }, itemClick = {
                    this@consumeData.root.findNavController().navigate(
                        GameFragmentDirections.actionGameFragmentToGameDetailFragment(gameId)
                    )
                    /* val intent by lazy {
                         Intent(
                             this@GameFragment.context,
                             GameDetailFragment::class.java
                         )
                     }
                     intent.putExtra(intentGamesDetailKey, gameId)
                     startActivity(intent)*/
                })
        }
    }
}
