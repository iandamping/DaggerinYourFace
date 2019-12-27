package com.junemon.daggerinyourface.view.root

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.junemon.daggerinyourface.MainApplication
import com.junemon.daggerinyourface.R
import com.junemon.daggerinyourface.databinding.ActivityRootBinding
import com.junemon.daggerinyourface.presentation.base.BaseActivity
import com.junemon.daggerinyourface.view.root.component.RootActivityComponent

class RootActivity : BaseActivity() {

    lateinit var rootActivityComponent: RootActivityComponent

    private lateinit var binding: ActivityRootBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootActivityComponent = (application as MainApplication).appComponent
            .getRootActivityComponent().create()
        // Injects this activity to the just created All Fragment component
        rootActivityComponent.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_root)
        binding.lifecycleOwner = this
        binding.initBottomNav()
    }

    private fun ActivityRootBinding.initBottomNav() {
        apply {
            with(Navigation.findNavController(this@RootActivity, R.id.learnNavHostFragment)) {
                bottomNav.setupWithNavController(this@with)
                addOnDestinationChangedListener { _, destination, _ ->
                    when (destination.id) {
                        R.id.gameFragment -> bottomNav.visibility = View.VISIBLE
                        R.id.publisherFragment -> bottomNav.visibility = View.VISIBLE
                        else -> bottomNav.visibility = View.GONE
                    }
                }
            }
        }
    }
}
