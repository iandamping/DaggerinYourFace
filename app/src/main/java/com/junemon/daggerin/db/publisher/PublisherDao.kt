package com.junemon.daggerin.db.publisher

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PublisherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPublisher(vararg data: PublisherDbEntity)

    @Query("SELECT * FROM table_publisher")
    fun loadPublisher(): Flow<List<PublisherDbEntity>>
}