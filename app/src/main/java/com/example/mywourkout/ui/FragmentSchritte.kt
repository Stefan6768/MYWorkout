package com.example.mywourkout.ui

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentSchritteBinding


class FragmentSchritte : Fragment(), SensorEventListener {

  private lateinit var binding: FragmentSchritteBinding


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
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

  override fun onSensorChanged(p0: SensorEvent?) {
    TODO("Not yet implemented")
  }

  override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    TODO("Not yet implemented")
  }
}