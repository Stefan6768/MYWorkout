package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentZweiBinding


class FragmentZwei : Fragment() {

  lateinit var binding: FragmentZweiBinding


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_zwei, container, false)

    return binding.root
  }
}
