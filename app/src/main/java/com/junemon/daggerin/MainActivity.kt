package com.junemon.daggerin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junemon.daggerin.dagger.DaggerMonsterComponent
import com.junemon.daggerin.dagger.MonsterComponent
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.monster.Monster
import com.junemon.daggerin.monster.MyMonster

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var myMonster: MyMonster


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val component: MonsterComponent = DaggerMonsterComponent.create()
        myMonster = component.getMyMonster()
        binding.tvDragon.text = myMonster.summonMyMonster()


    }
}