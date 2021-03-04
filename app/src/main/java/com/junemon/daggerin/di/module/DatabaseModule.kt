package com.junemon.daggerin.di.module

import android.content.Context
import androidx.room.Room
import com.junemon.daggerin.db.GameDatabase
import com.junemon.daggerin.db.game.GameDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @JvmStatic
    @Singleton
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