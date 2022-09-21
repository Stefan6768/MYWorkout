package com.example.mywourkout.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User (
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,
  var geschlecht: String,
  var groesse: String,
  var gewicht: String,
  var alter: String

        )
