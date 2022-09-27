package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentEditPersdatenBinding

class FragmentEditPersdaten : Fragment() {

  private lateinit var binding: FragmentEditPersdatenBinding


  private var geschlechtid = ""
  private var gewichtid = ""
  private var groesseid = ""
  private var alterid = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_persdaten, container, false)

    return binding.root
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }

    binding.saveButton.setOnClickListener {
      findNavController().navigate(FragmentEditPersdatenDirections.actionFragmentEditPersdatenToFragmentSaveUser(
        geschlechtid, groesseid,gewichtid,alterid
      ))
    }

  }
}