package com.junemon.daggerinyourface.data.db.publisher.paging

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PublisherPagingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPublisher(vararg data: PublisherPagingDbEntity)

    @Query("SELECT * FROM table_publisher_pagination")
    fun loadPublisher(): DataSource.Factory<Int, PublisherPagingDbEntity>
}
