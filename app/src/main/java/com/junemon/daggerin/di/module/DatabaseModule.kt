package com.junemon.daggerin.di.module

import android.content.Context
import androidx.room.Room
import com.junemon.daggerin.db.GameDatabase
import com.junemon.daggerin.db.game.GameDao
import com.junemon.daggerin.di.qualifier.ApplicationContext
import com.junemon.daggerin.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Provides
    @JvmStatic
    @ApplicationScope
    fun provideDb(@ApplicationContext context: Context): GameDatabase {
        return Room
            .databaseBuilder(context, GameDatabase::class.java, "games.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @JvmStatic
    fun provideGameDao(db: GameDatabase): GameDao {
        return db.gameDao()
    }

}