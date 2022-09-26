package com.example.mywourkout.local

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mywourkout.data.datamodels.User
import com.example.mywourkout.data.datamodels.Video
import com.example.mywourkout.remote.VideoApi

const val TAG = "Repository"

class RepositoryUser(private val database: UserDatabase) {


  val userList: LiveData<List<User>> = database.userDatabaseDao.getAll()

  suspend fun insert(user: User) {
    try {
      database.userDatabaseDao.insert(user)
    }catch (e: Exception) {
      Log.d(TAG, "Failed to insert into Database: $e")
    }
  }

  suspend fun update(user: User) {
    try {
      database.userDatabaseDao.update(user)
    } catch (e: Exception) {
      Log.d(TAG,"Failed to update Database: $e")
    }
  }

  suspend fun  delete(id: Long) {
    try {
      database.userDatabaseDao.deleteById(id)
    } catch (e: Exception) {
      Log.d(TAG, "Failed to delete from Database: $e")
    }
  }

}