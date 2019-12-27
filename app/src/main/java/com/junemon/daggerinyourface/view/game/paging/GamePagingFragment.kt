package com.junemon.daggerinyourface.view.game.paging

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
import androidx.paging.PagedList
import com.junemon.daggerinyourface.R
import com.junemon.daggerinyourface.databinding.FragmentPagingGameBinding
import com.junemon.daggerinyourface.domain.model.GamePagingData
import com.junemon.daggerinyourface.presentation.Constant
import com.junemon.daggerinyourface.presentation.base.BaseFragment
import com.junemon.daggerinyourface.presentation.interfaces.LoadImageHelper
import com.junemon.daggerinyourface.presentation.util.interfaces.RecyclerHelper
import com.junemon.daggerinyourface.presentation.vm.GamePresentationViewModel
import com.junemon.daggerinyourface.view.root.RootActivity
import javax.inject.Inject
import kotlinx.android.synthetic.main.item_games.view.*

class GamePagingFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val gameViewModel: GamePresentationViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: FragmentPagingGameBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent
            .getGamesPresentationComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_paging_game, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            observeData()
        }
        return binding.root
    }

    fun FragmentPagingGameBinding.observeData() {
        apply {
            gameViewModel.getPaginationCache().observe(viewLifecycleOwner, Observer { result ->
                consumeData(result)
            })
        }
    }

    private fun FragmentPagingGameBinding.consumeData(result: PagedList<GamePagingData>?) {
        recyclerHelper.run {
            rvMain.setUpPagingVertical(items = result,
                diffUtil = Constant.gamesPagingDiffCallbacks,
                layoutResId = R.layout.item_games,
                bindHolder = {
                    tvText.text = it.gameName
                    loadImageHelper.run {
                        ivImages.loadWithGlide(it.gameImage)
                    }
                }, itemClick = {
                    this@consumeData.root.findNavController().navigate(
                        GamePagingFragmentDirections.actionGamePagingFragmentToGameDetailFragment(
                            gameId
                        )
                    )
                })
        }
    }
}
