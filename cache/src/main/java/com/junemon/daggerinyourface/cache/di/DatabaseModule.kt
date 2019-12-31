package com.junemon.daggerinyourface.cache.di

import android.app.Application
import androidx.room.Room
import com.junemon.daggerinyourface.cache.GameDatabase
import com.junemon.daggerinyourface.data.db.game.normal.GameDao
import com.junemon.daggerinyourface.data.db.game.paging.GamePagingDao
import com.junemon.daggerinyourface.data.db.publisher.normal.PublisherDao
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDao
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
    fun provideGamePagingDao(db: GameDatabase): GamePagingDao {
        return db.gamePagingDao()
    }

    @Provides
    @JvmStatic
    fun providePublisherDao(db: GameDatabase): PublisherDao {
        return db.publisherDao()
    }

    @Provides
    @JvmStatic
    fun providePublisherPagingDao(db: GameDatabase): PublisherPagingDao {
        return db.publisherPagingDao()
    }
}
