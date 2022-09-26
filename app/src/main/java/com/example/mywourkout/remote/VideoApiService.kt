package com.example.mywourkout.remote

import android.provider.MediaStore
import com.example.mywourkout.data.datamodels.Video
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://public.syntax-institut.de/apps/batch2/StefanSchreiber"

private val moshi = Moshi.Builder()
  .add(KotlinJsonAdapterFactory())
  .build()

private val retrofit = Retrofit.Builder()
  .addConverterFactory(MoshiConverterFactory.create(moshi))
  .baseUrl(BASE_URL)
  .build()

interface VideoApiService {

  @GET("data.json")
  suspend fun getVideos(): List<Video>
}

object VideoApi {
  val retrofitService: VideoApiService by lazy { retrofit.create(VideoApiService::class.java) }
}

