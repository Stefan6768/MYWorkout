package com.example.mywourkout.data

import com.example.myworkout.data.model.Workout
import com.example.mywourkout.R

class Datasource {

  fun loadMyworkout(): List<Workout> {
    return listOf(
      Workout("Arm Training", R.drawable.workout1),
      Workout("Bauch Training", R.drawable.workout2),
      Workout("Bein Training", R.drawable.workout3),
      Workout("Cardio Training", R.drawable.workout4),
      Workout("Ganz Körper Training", R.drawable.workout5),
      Workout("Po Training", R.drawable.workout6),
      Workout("Youtube Videos", R.drawable.workout7),
      Workout("Trainings Videos", R.drawable.workout8),
      Workout("Persönliche Daten",R.drawable.workout9),
      Workout("Schrittzähler",R.drawable.workout10),
      Workout("Kalorienzähler", R.drawable.workout11),
      Workout("Trainingsplaner", R.drawable.workout12)
      )
  }
}