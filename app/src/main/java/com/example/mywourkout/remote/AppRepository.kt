package com.example.mywourkout.remote

import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mywourkout.data.datamodels.Video
//import com.example.mywourkout.local.VideoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*const val TAG = "AppRepositoryTAG"

*//**
 * Diese Klasse holt die Informationen und stellt sie mithilfe von Live Data dem Rest
 * der App zur Verfügung
 *//*
class AppRepository (private val api: VideoApi, private val database: VideoDatabase) {

  // Die LiveData Variable memes enthält die Liste aus dem API call
 private val _videos = MutableLiveData<List<MediaStore.Video>>()
  val videos: MutableLiveData<List<MediaStore.Video>>
  get() = _videos


  *//**
   * Diese Funktion ruft die Daten aus dem API Service ab und speichert die Antwort in der
   * Variable memes. Falls der Call nicht funktioniert, wird die Fehlermeldung geloggt
   *//*
  suspend fun getVideos() {
    Log.e(TAG, "get Videos")
    withContext(Dispatchers.IO)
    {
      val videoData = api.retrofitService.getVideos().data.videos
     database.videoDatabaseDao.insertAll(videoData)
    }

    suspend fun deleteVideos(id: Long) {
     try {
       database.videoDatabaseDao.deleteByld(id)
     } catch (e: Exception) {
       Log.d(TAG, "Failed to deleteVideo from Database: $e")
      }
    }

    suspend fun deleteAllVideos() {
     try {
        database.videoDatabaseDao.deleteAll()
      } catch (e: Exception) {
       Log.d(TAG, "Failed to deleteAllVideos from Database: $e")
     }
    }
   suspend fun updateVideo(video: Video) {
    try {
        database.videoDatabaseDao.update(video)
      } catch (e: Exception) {
       Log.d(TAG,"Failed to update database")
     }
   }
  }
}*/


