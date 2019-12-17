package com.junemon.daggerin.tutorial.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junemon.daggerin.tutorial.DaggerApplication
import com.junemon.daggerin.tutorial.dagger.component.ActivityComponent
import com.junemon.daggerin.tutorial.dagger.module.DieselEngineModule
import com.junemon.daggerin.tutorial.model.Car
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {
    //    private val car:Car by lazy { DaggerCarComponent.create().getCar() }

    /*Field injection*/
    @Inject
    lateinit var car1: Car
    @Inject
    lateinit var car2: Car

    /* *//*Inject this component with manual constructor using builder pattern*//*
    private val car: Car by lazy {
        DaggerCarComponent.builder().horsePower(2)
            .engineCapacity(500).build().getCar()
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*val activityComponent: ActivityComponent by lazy {
            *//*Now we using component from application scope that anotated with singleton
            * and it works !*//*
            DaggerApplication.DaggerApplications.component
        }*/

      /*  val activityComponent: ActivityComponent by lazy {
            *//*Now we using component from application scope as a part of dagger activity component
            *
            * now it really work like real apps need*//*
            DaggerActivityComponent.builder().horsePower(300).engineCapacity(2000)
                .appComponent(DaggerApplication.DaggerApplications.component).build()
        }*/

        val activityComponent: ActivityComponent by lazy {
            /*Now we using subcomponent
            *
            * now it really work like real apps need*/
            DaggerApplication.DaggerApplications.component.getActivityComponent(DieselEngineModule(30))
        }
        activityComponent.inject(this)

        car1.drive()
        car2.drive()
    }
}