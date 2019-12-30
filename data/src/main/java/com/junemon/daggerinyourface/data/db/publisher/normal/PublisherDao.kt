package com.junemon.daggerinyourface.data.db.publisher.normal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.junemon.daggerinyourface.model.data.database.publisher.PublisherDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PublisherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPublisher(vararg data: PublisherDbEntity)

    @Query("SELECT * FROM table_publisher")
    fun loadPublisher(): Flow<List<PublisherDbEntity>>
}
