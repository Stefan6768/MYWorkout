package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentStartBinding

class StartFragment : Fragment() {

  lateinit var binding: FragmentStartBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    binding.startButton.setOnClickListener {
      findNavController().navigate(StartFragmentDirections.actionStartFragmentToFragmentEins())
      
    }
  }
}