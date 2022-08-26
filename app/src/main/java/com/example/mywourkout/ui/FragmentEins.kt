package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mywourkout.R
import com.example.mywourkout.adapter.WorkAdapter
import com.example.mywourkout.data.Datasource
import com.example.mywourkout.databinding.FragmentEinsBinding

class FragmentEins : Fragment() {

  private lateinit var binding: FragmentEinsBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_eins, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    val myworkout = Datasource().loadMyworkout()

    binding.workoutRecycler.adapter = WorkAdapter(requireContext(), myworkout)

    binding.workoutRecycler.setHasFixedSize(true)
  }



}