package com.junemon.daggerin.feature.detail.game.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseFragment
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.databinding.ActivityDetailGameBinding
import com.junemon.daggerin.feature.root.RootActivity
import com.junemon.daggerin.util.Constant.intentGamesDetailKey
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import javax.inject.Inject

class GameDetailFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: ActivityDetailGameBinding

    private val viewModel: GameDetailViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent
            .getGamesDetailComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val detailID by lazy { GameDetailFragmentArgs.fromBundle(arguments!!).gameID }
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_detail_game, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            observeData(detailID)
        }
        return binding.root
    }


    fun ActivityDetailGameBinding.observeData(detailID: Int) {
        apply {
            viewModel.getData(detailID).observe(viewLifecycleOwner, Observer { result ->
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