package com.junemon.daggerin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.junemon.daggerin.db.game.GameDao
import com.junemon.daggerin.db.game.GameDbEntity

@Database(entities = [GameDbEntity::class],version = 1,exportSchema = false)
abstract class GameDatabase: RoomDatabase() {

    abstract fun gameDao():GameDao
}