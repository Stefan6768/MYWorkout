package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentPersdatenBinding

class FragmentPersDaten : Fragment() {

  private lateinit var binding: FragmentPersdatenBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_persdaten, container, false)

    return binding.root
  }
}