package com.junemon.daggerin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junemon.daggerin.dagger.DaggerDragonComponent
import com.junemon.daggerin.dagger.DragonComponent
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.monster.Dragon

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var myInjectedMonster: Dragon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val component: DragonComponent = DaggerDragonComponent.create()
        myInjectedMonster = component.getDragon()

        binding.tvMain.text = myInjectedMonster.getMonsterName()
    }
}