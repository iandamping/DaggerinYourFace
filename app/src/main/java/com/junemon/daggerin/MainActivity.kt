package com.junemon.daggerin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junemon.daggerin.dagger.DaggerMonsterComponent
import com.junemon.daggerin.dagger.MonsterComponent
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.monster.Monster

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var myDragon: Monster

    private lateinit var myGoblin: Monster

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val component: MonsterComponent = DaggerMonsterComponent.create()
        with(component) {
            myDragon = getDragon()
            myGoblin = getGoblin()
        }
        with(binding) {
            tvDragon.text = myDragon.getMonsterName()
            tvGoblin.text = myGoblin.getMonsterName()
        }

    }
}