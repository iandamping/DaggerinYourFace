package com.junemon.daggerin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junemon.daggerin.dagger.activityComponent
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.monster.MyMonster
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var myMonster: MyMonster


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDragon.text = myMonster.summonMyMonster()


    }
}