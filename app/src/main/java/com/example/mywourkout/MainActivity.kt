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
class MainActivity : AppCompatActivity() {



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

    // Das Binding zur XML-Datei
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    navController = findNavController(R.id.fragmentContainerView)

    binding.bottomNav.setupWithNavController(navController)


  }
}
