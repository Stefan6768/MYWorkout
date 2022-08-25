package com.example.mywourkout.data

import com.example.mywourkout.R
import com.example.mywourkout.data.model.Myworkout

class Datasource {

  fun loadMyworkout(): List<Myworkout> {
    return listOf(
      Myworkout("Arm Training", R.drawable.workout1),
      Myworkout("Bauch Training", R.drawable.workout2),
      Myworkout("Bein Training", R.drawable.workout3),
      Myworkout("Cardio Training", R.drawable.workout4),
      Myworkout("Ganz Körper Training", R.drawable.workout5),
      Myworkout("Po Training", R.drawable.workout6),
      Myworkout("You Tube Training", R.drawable.workout7),
      Myworkout("Video Training", R.drawable.workout8)
    )
  }
}