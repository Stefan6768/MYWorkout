package com.example.mywourkout.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mywourkout.data.datamodels.User

@Dao
interface UserDataBaseDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun  insert(user: User)

  @Update
  suspend fun update(user: User)

  @Query("SELECT * FROM User")
  fun getAll(): LiveData<List<User>>

  @Query("DELETE FROM User WHERE id = :id")
  suspend fun  deleteById(id: Long)

}