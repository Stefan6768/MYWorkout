package com.example.mywourkout

import android.animation.ObjectAnimator
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mywourkout.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Main Activity dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity(), SensorEventListener {

  private var sensorManager: SensorManager? = null


  private var running = false


  private var totalSteps = 0f


  private var previousTotalSteps = 0f

  /*   Klassen Variablen   */

  private lateinit var binding: ActivityMainBinding

  private lateinit var navController: NavController


  /*  Lifecycle  */

  /**
   * Lifecycle Methode, wird aufgerufen wenn Activity estellt wird
   *
   * @param savedInstanceState  Save state vom view
   */

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    loadData()
    resetSteps()

    sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

    // Das Binding zur XML-Datei
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    navController = findNavController(R.id.fragmentContainerView)

    binding.bottomNav.setupWithNavController(navController)


  }

  override fun onResume() {
    super.onResume()
    running = true


    val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)


    if (stepSensor == null) {

      Toast.makeText(this, "No sensor detected on this device", Toast.LENGTH_SHORT).show()
    } else {

      sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
    }
  }

  override fun onSensorChanged(event: SensorEvent?) {
    val tv_stepsTaken = findViewById<TextView>(R.id.steps_text)

    if (running) {
      totalSteps = event!!.values[0]


      val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()


      tv_stepsTaken.text = ("$currentSteps")
    }
  }

  private fun resetSteps() {


    val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

    val editor = sharedPreferences.edit()
    editor.putFloat("key1", previousTotalSteps)
    editor.apply()
  }





  private fun loadData() {


    val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
    val savedNumber = sharedPreferences.getFloat("key1", 0f)


    Log.d("MainActivity", "$savedNumber")

    previousTotalSteps = savedNumber
  }

  override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

  }

}
