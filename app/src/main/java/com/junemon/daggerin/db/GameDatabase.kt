package com.junemon.daggerin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.junemon.daggerin.db.game.GameDao
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.db.publisher.PublisherDao
import com.junemon.daggerin.db.publisher.PublisherDbEntity

@Database(
    entities = [GameDbEntity::class, PublisherDbEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GameDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    abstract fun publisherDao(): PublisherDao
}