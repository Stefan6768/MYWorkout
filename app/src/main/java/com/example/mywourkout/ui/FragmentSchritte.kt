package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentSchritteBinding

class FragmentSchritte : Fragment() {

  private lateinit var binding: FragmentSchritteBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_schritte, container, false)

    return binding.root
  }
}