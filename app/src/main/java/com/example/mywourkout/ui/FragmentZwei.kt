package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentZweiBinding


class FragmentZwei : Fragment() {

  private lateinit var binding: FragmentZweiBinding

  private var stringId = ""
  private var imageId = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (arguments != null) {
      stringId = arguments!!.getString("stringid").toString()
      imageId = arguments!!.getInt("imageid")
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

    binding.returnButton2.setOnClickListener {
      findNavController().navigateUp()
    }

    binding.min5Button.setOnClickListener {
      findNavController().navigate(FragmentZweiDirections.actionFragmentZweiToFragmentDrei())
    }

    binding.min10Button.setOnClickListener{
      findNavController().navigate(FragmentZweiDirections.actionFragmentZweiToFragmentDrei())
    }

    binding.min15Button.setOnClickListener {
     findNavController().navigate(FragmentZweiDirections.actionFragmentZweiToFragmentDrei())
    }

    binding.detailImage.setImageResource(imageId)

    binding.detailText.text = stringId
  }

}
