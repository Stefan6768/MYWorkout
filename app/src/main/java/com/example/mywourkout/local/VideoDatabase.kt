package com.example.mywourkout.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mywourkout.data.datamodels.Video

/*@Database(entities = [Video::class], version = 1)
abstract class VideoDatabase : RoomDatabase() {

  abstract val videoDatabaseDao: VideoDatabaseDao

}

private lateinit var INSTANCE: VideoDatabase

fun getDatabase(context: Context): VideoDatabase {
  kotlin.synchronized(VideoDatabase::class.java) {
   if (!::INSTANCE.isInitialized) {
     INSTANCE = Room.databaseBuilder(
        context.applicationContext,
        VideoDatabase::class.java,
        "video_database"
      )
        .build()
    }
  }
  return INSTANCE
}*/
