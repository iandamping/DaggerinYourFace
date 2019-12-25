package com.junemon.daggerin.data.di.module

import android.app.Application
import androidx.room.Room
import com.junemon.daggerin.data.db.GameDatabase
import com.junemon.daggerin.data.db.game.GameDao
import com.junemon.daggerin.data.db.publisher.PublisherDao
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

    @Provides
    @JvmStatic
    fun providePublisherDao(db: GameDatabase): PublisherDao {
        return db.publisherDao()
    }
}
