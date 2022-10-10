package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentTrainingseinheitBinding


class FragmentTrainingseinheit : Fragment() {

  private lateinit var binding: FragmentTrainingseinheitBinding

  private var stringId = ""
  private var imageId = 0
  private var trainingsId = ""


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (arguments != null) {
      stringId = requireArguments()!!.getString("stringid").toString()
      imageId = requireArguments()!!.getInt("imageid")
      trainingsId = requireArguments()!!.getString("trainingsId").toString()
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trainingseinheit, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }

    binding.min5Button.setOnClickListener {
      findNavController().navigate(
        FragmentTrainingseinheitDirections.actionFragmentZweiToFragmentSportVideo(
          stringId, "5 min", trainingsId
        )
      )
    }

    binding.min10Button.setOnClickListener {
      findNavController().navigate(
        FragmentTrainingseinheitDirections.actionFragmentZweiToFragmentSportVideo(
          stringId, "10 min", trainingsId
        )
      )
    }

    binding.min15Button.setOnClickListener {
      findNavController().navigate(
        FragmentTrainingseinheitDirections.actionFragmentZweiToFragmentSportVideo(
          stringId, "15 min", trainingsId
        )
      )
    }

    binding.detailImage.setImageResource(imageId)

    binding.detailText.text = stringId
  }
}
