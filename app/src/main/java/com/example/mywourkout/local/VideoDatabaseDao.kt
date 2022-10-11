package com.example.mywourkout.local


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mywourkout.data.datamodels.Video


/*
@Dao
interface VideoDatabaseDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAll(video: List<Video>)

  @Update
  suspend fun update(video: Video)

 @Query("SELECT * FROM Video")
  fun getAll(): LiveData<List<Video>>

  @Query("DELETE FROM Video")
  suspend fun deleteAll()

  @Query("DELETE FROM Video WHERE id = :id")
  suspend fun delteByld(id: String)


}*/
