package com.junemon.daggerinyourface.view.game

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
import com.junemon.daggerinyourface.R
import com.junemon.daggerinyourface.presentation.base.BaseFragment
import com.junemon.daggerinyourface.domain.model.ResultToConsume
import com.junemon.daggerinyourface.databinding.ActivityMainBinding
import com.junemon.daggerinyourface.presentation.Constant.gamesDiffCallbacks
import com.junemon.daggerinyourface.view.root.RootActivity
import com.junemon.daggerinyourface.presentation.vm.GamePresentationViewModel
import com.junemon.daggerinyourface.presentation.interfaces.LoadImageHelper
import com.junemon.daggerinyourface.presentation.model.GamePresentation
import com.junemon.daggerinyourface.presentation.model.mapToPresentation
import com.junemon.daggerinyourface.presentation.util.interfaces.RecyclerHelper
import kotlinx.android.synthetic.main.item_games.view.*
import javax.inject.Inject

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
                diffUtil = gamesDiffCallbacks,
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
                })
        }
    }
}
