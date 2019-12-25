package com.junemon.daggerin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.junemon.daggerin.data.db.game.GameDao
import com.junemon.daggerin.data.db.game.GameDbEntity
import com.junemon.daggerin.data.db.publisher.PublisherDao
import com.junemon.daggerin.data.db.publisher.PublisherDbEntity

@Database(
    entities = [GameDbEntity::class, PublisherDbEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GameDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    abstract fun publisherDao(): PublisherDao
}
