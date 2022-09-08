package com.example.mywourkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import androidx.databinding.DataBindingUtil
import com.example.mywourkout.databinding.ActivityMainBinding

/**
 * Main Activity dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {

  /*   Klassen Variablen   */

  private lateinit var binding: ActivityMainBinding

  /*  Lifecycle  */

  /**
   * Lifecycle Methode, wird aufgerufen wenn Activity estellt wird
   *
   * @param savedInstanceState  Save state vom view
   */

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Das Binding zur XML-Datei
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
  }

}
