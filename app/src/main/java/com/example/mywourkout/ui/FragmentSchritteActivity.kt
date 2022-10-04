package com.example.mywourkout.ui

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.data.Datasource
import com.example.mywourkout.databinding.FragmentSchritteActivityBinding


abstract class FragmentSchritteActivity :  AppCompatActivity(), SensorEventListener {

  private lateinit var binding: FragmentSchritteActivityBinding

  private var sensorManager: SensorManager? = null

  private var running = false

  private var totalSteps = 0f

  private var previousTotalSteps = 0f

  override fun onCreate(savedInstanceState: Bundle?) {
    super<AppCompatActivity
    >.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_schritte_activity)

    loadData()
    resetSteps()

    sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
  }

  override fun onResume() {
    super<AppCompatActivity>.onResume()
    super<AppCompatActivity>.onResume()
    running = true

    val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

    if (stepSensor == null) {

      Toast.makeText(this, "Keinen Sensor auf diesem Gerät erkannt", Toast.LENGTH_SHORT).show()
    } else {
      sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
    }
  }

  override fun onSensorChanged(event: SensorEvent?) {

    val tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)

    if (running) {
      totalSteps = event!!.values[0]

      val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()

      tv_stepsTaken.text = ("$currentSteps")
    }
  }

  private fun resetSteps() {
    val tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
    tv_stepsTaken.setOnClickListener {

      Toast.makeText(this, "Lange tippen! Zum Zurücksetzen", Toast.LENGTH_SHORT).show()
    }

    tv_stepsTaken.setOnLongClickListener {

      previousTotalSteps = totalSteps

      tv_stepsTaken.text = 0.toString()

      saveData()

      true
    }
  }

  private fun saveData() {

    val sharedPrefenrences = getSharedPreferences("Meine Einstellung", Context.MODE_PRIVATE)

    val editor = sharedPrefenrences.edit()
    editor.putFloat("key1", previousTotalSteps)
    editor.apply()
  }

  private fun loadData() {

    val sharedPreferences = getSharedPreferences("Meine Einstellung", Context.MODE_PRIVATE)
    val savedNumber = sharedPreferences.getFloat("key1", 0f)

    Log.d("FragmentSchritte", "$savedNumber")

    previousTotalSteps = savedNumber

    fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
  }


  fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_schritte_activity, container, false)

    return binding.root
  }

  fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    val myworkout = Datasource().loadMyworkout()

    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }

  }

  abstract fun findNavController(): NavController

}