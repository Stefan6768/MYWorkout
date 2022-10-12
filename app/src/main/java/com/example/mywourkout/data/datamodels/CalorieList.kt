package com.example.mywourkout.data.datamodels

class CalorieList {

  private val _calories = loadMyworkout()
  val calories: List<Calorie>
  get() = _calories

  fun loadMyworkout(): List<Calorie> {
    return listOf(
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),
      Calorie("","","","","",""),


      Calorie("","","","","","")
    )
  }
}