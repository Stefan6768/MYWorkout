package com.example.mywourkout.data.datamodels

import android.security.identity.AccessControlProfileId
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User (
  @PrimaryKey(autoGenerate = true)
  var id: Int,
  var geschlecht: String,
  var groesse: String,
  var gewicht: String,
  var alter: String

        )
