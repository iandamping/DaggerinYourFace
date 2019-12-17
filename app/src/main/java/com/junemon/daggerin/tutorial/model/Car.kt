package com.junemon.daggerin.tutorial.model

import android.util.Log
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
import javax.inject.Inject
/*Engine disini hanyalah interface, yang di instantiated dari DieselEngine & PetrolEngine class
* disini kita menggunakan anotasi perActivity yg akan create singleton yang masa hidupnya
* sepanjang activity saja*/

@PerActivity
class Car @Inject constructor(private val engine: Engine, private val wheel: Wheels,private val driver: Driver) {
    private val TAG = "Car"

    fun drive(){
        Log.d(TAG, "drive: Bruummm im driving using $this with $driver")
        /*untuk mengetahui engine mana yang kita gunakan*/
        engine.startEngine()
    }
}