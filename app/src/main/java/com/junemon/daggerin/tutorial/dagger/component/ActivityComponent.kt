package com.junemon.daggerin.tutorial.dagger.component

import com.junemon.daggerin.tutorial.activity.DaggerActivity
import com.junemon.daggerin.tutorial.dagger.module.DieselEngineModule
import com.junemon.daggerin.tutorial.dagger.module.WheelsModule
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
import com.junemon.daggerin.tutorial.model.Car
import dagger.Subcomponent

/*jika ada salah satu class yang menggunakan anotasi singleton component ini juga harus
    * menggunakan anotasi singleton
    *
    * note : kita merubah anotasi singleton menjadi PerActivity  singleton
    *
    * dependecies artinya, kita membutuhkan AppComponent untuk bisa create ActivityComponent ini*/
//@PerActivity
//@Component(dependencies = [AppComponent::class],modules = [WheelsModule::class, PetrolEngineModule::class])
//interface ActivityComponent {
//
//    fun getCar():Car
//
//    //field injection
//    fun inject(activity:DaggerActivity)
//
//    /*Injecting PetrolEngine class constructor with Component Builder,
//    * lebih disarankan menggunakan teknik ini daripada menggunakan
//    * passing value melalui Constructor Module class seperti di DieselEngineModule class*/
//    @Component.Builder
//    interface Builder{
//        /*We using named anotation to know which is the value we will be using to create PetrolEngine class*/
//        @BindsInstance
//        fun horsePower(@Named("Horse Power")horsePower:Int):Builder
//
//        @BindsInstance
//        fun engineCapacity(@Named("Engine Capacity")engineCapacity:Int):Builder
//
//        /*karena kita menggunakan builder kita harus explicitly create builder component ini*/
//        fun appComponent(component:AppComponent):Builder
//
//        fun build():ActivityComponent
//    }
//}

/*Disini kita menggunakan subcomponent agar activity component bisa mengakses semua yang ada dalam
* applicationComponent supaya applicationComponent tidak perlu ekspose object didalamnya*/
@PerActivity
@Subcomponent(modules = [WheelsModule::class, DieselEngineModule::class])
interface ActivityComponent {

    fun getCar():Car

    //field injection
    fun inject(activity:DaggerActivity)

    /*Injecting PetrolEngine class constructor with Component Builder,
    * lebih disarankan menggunakan teknik ini daripada menggunakan
    * passing value melalui Constructor Module class seperti di DieselEngineModule class*/
//    @Component.Builder
//    interface Builder{
//        /*We using named anotation to know which is the value we will be using to create PetrolEngine class*/
//        @BindsInstance
//        fun horsePower(@Named("Horse Power")horsePower:Int):Builder
//
//        @BindsInstance
//        fun engineCapacity(@Named("Engine Capacity")engineCapacity:Int):Builder
//
//        /*karena kita menggunakan builder kita harus explicitly create builder component ini*/
//        fun appComponent(component:AppComponent):Builder
//
//        fun build():ActivityComponent
//    }
}