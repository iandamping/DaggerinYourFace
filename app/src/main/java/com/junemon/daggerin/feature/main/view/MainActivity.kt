package com.junemon.daggerin.feature.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.MainApplication.appComponent.applicationComponent
import com.junemon.daggerin.R
import com.junemon.daggerin.feature.main.component.MainActivityComponent
import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import com.junemon.daggerin.model.GameCallback
import com.junemon.daggerin.model.GamesEntity
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import kotlinx.android.synthetic.main.item_games.view.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    MainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var recyclerHelper:RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper


    private val mainActivityComponent: MainActivityComponent by lazy {
       applicationComponent.getMainActivityComponent().injectView(this)
    }

    /*private val recyclerHelper by lazy {
        mainActivityComponent.getRecyclerHelper()
    }*/

   /* private val loadImageHelper by lazy {
        mainActivityComponent.getLoadImageHelper()
    }*/

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityComponent.injectActivity(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter.apply {
            attachLifecycle(this@MainActivity)
            getData()
        }
    }


    override fun observeData(data: List<GamesEntity>) {
        if (::binding.isInitialized) {
            binding.apply {
                recyclerHelper.run {
                    rvMain.setUpVerticalListAdapter(items = data,
                        diffUtil = GameCallback.gamesDiffCallbacks,
                        layoutResId = R.layout.item_games,
                        bindHolder = {
                            tvText.text = it.name
                            loadImageHelper.run {
                                ivImages.loadWithGlide(it.backgroundImage)
                            }
                        }, itemClick = {
                            val intent by lazy {
                                Intent(
                                    this@MainActivity,
                                    PublisherActivity::class.java
                                )
                            }
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
