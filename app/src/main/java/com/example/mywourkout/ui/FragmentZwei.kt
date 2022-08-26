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

  private lateinit var binding: FragmentZweiBinding

  private var stringId = 0
  private var imageId = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (arguments != null) {
      stringId = arguments!!.getInt("stringId")
      imageId = arguments!!.getInt("imageId")
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_zwei, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    binding.detailImage.setImageResource(imageId)

    binding.detailText.text = getString(stringId)
  }

}
