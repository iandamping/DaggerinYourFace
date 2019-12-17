package com.junemon.daggerin.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.MainApplication.appComponent.component
import com.junemon.daggerin.R
import com.junemon.daggerin.di.component.ActivityComponent
import com.junemon.daggerin.di.module.MainPresenterModule
import com.junemon.daggerin.model.GamesEntity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    private val TAG = "MainActivity"

    private val activityComponent: ActivityComponent by lazy {
        component.getActivityComponent(MainPresenterModule(this))
    }

    @Inject
    lateinit var presenter: MainPresenter

    private val adapter: MainAdapter by lazy { MainAdapter() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter.apply {
            attachLifecycle(this@MainActivity)
            getData()
        }
    }


    override fun observeData(data: List<GamesEntity>) {
        adapter.submitList(data)
        if (::binding.isInitialized) {
            binding.apply {
                rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
                rvMain.adapter = adapter
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
