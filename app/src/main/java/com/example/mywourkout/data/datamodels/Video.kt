package com.example.mywourkout.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Video(
  @PrimaryKey
  val id: String,
  val video: String,
  val tag: String
)
