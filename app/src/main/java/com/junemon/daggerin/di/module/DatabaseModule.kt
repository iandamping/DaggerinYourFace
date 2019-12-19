package com.junemon.daggerin.di.module

import android.app.Application
import androidx.room.Room
import com.junemon.daggerin.db.GameDatabase
import com.junemon.daggerin.db.game.GameDao
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {

    @Provides
    @JvmStatic
    fun provideDb(app: Application): GameDatabase {
        return Room
            .databaseBuilder(app, GameDatabase::class.java, "games.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @JvmStatic
    fun provideGameDao(db: GameDatabase): GameDao {
        return db.gameDao()
    }

}