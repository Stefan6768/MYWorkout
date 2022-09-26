package com.example.mywourkout.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mywourkout.data.datamodels.Video
import com.example.mywourkout.remote.VideoApi

class RepositoryVideo (private val videoApi: VideoApi) {

  private val _videoList = MutableLiveData<List<Video>>()
  val videoList: LiveData<List<Video>>
    get() = _videoList

  suspend fun getVideos() {
    _videoList.value = videoApi.retrofitService.getVideos()

  }
}