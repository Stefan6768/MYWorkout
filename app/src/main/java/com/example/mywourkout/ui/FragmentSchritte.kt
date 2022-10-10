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
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentSchritteBinding


class FragmentSchritte : Fragment(), SensorEventListener {

  private lateinit var binding: FragmentSchritteBinding
  private var sensorManager: SensorManager? = null
  private var running = false
  private var totalSteps = 0f
  private var previousTotalSteps = 0f

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    loadData()
    //resetSteps()

    sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
  }

  override fun onResume() {
    super.onResume()
    running = true

    val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)


    if (stepSensor == null) {

      Toast.makeText(requireContext(), "No sensor detected on this device", Toast.LENGTH_SHORT).show()
    } else {

      sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
    }
  }


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_schritte, container, false)

    binding.lifecycleOwner = this.viewLifecycleOwner

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }
  }

  override fun onSensorChanged(event: SensorEvent?) {

    if (running) {

      totalSteps = event!!.values[0]

      val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()

      binding.stepsValue.text = ("$currentSteps")

    }
  }

  private fun resetSteps() {

    binding.stepsValue.setOnClickListener {

      Toast.makeText(requireContext(), "Long tap to reset steps", Toast.LENGTH_SHORT).show()
    }

    binding.stepsValue.setOnLongClickListener {

      previousTotalSteps = totalSteps


      binding.stepsValue.text = 0.toString()

      saveData()

      true
    }
  }

  private fun saveData() {


    val sharedPreferences = requireActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

    val editor = sharedPreferences.edit()
    editor.putFloat("key1", previousTotalSteps)
    editor.apply()
  }

  private fun loadData() {


    val sharedPreferences = requireActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
    val savedNumber = sharedPreferences.getFloat("key1", 0f)


    Log.d("FragmentSchritte", "$savedNumber")

    previousTotalSteps = savedNumber
  }


  override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
  }
}