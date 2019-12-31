package com.junemon.daggerinyourface.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.junemon.daggerinyourface.data.db.game.normal.GameDao
import com.junemon.daggerinyourface.data.db.game.normal.GameDbEntity
import com.junemon.daggerinyourface.data.db.game.paging.GamePagingDao
import com.junemon.daggerinyourface.data.db.game.paging.GamePagingDbEntity
import com.junemon.daggerinyourface.data.db.publisher.normal.PublisherDao
import com.junemon.daggerinyourface.data.db.publisher.normal.PublisherDbEntity
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDao
import com.junemon.daggerinyourface.data.db.publisher.paging.PublisherPagingDbEntity

@Database(
    entities = [GameDbEntity::class, GamePagingDbEntity::class, PublisherPagingDbEntity::class, PublisherDbEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GameDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    abstract fun gamePagingDao(): GamePagingDao

    abstract fun publisherDao(): PublisherDao

    abstract fun publisherPagingDao(): PublisherPagingDao
}
