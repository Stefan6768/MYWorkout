package com.example.mywourkout.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.data.Datasource
import com.example.mywourkout.data.datamodels.Video
import com.example.mywourkout.data.datamodels.VideoList
import com.example.mywourkout.databinding.FragmentKalenderBinding


class FragmentKalender : Fragment() {

  private lateinit var binding: FragmentKalenderBinding

  var myworkoutList: List<Video> = mutableListOf()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kalender, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    myworkoutList = VideoList().loadMyworkout()

    val calender = binding.kalenderView

    calender.setOnDateChangeListener(
      CalendarView.OnDateChangeListener { view, year, month, day ->
        compareDay(day.toString())
      }
    )



    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }

  }

  fun compareDay(day: String) {
    var isDay = myworkoutList.find {
      it.tag == day
    }

    // fragment erstellt das Video zum Tag
    if (isDay!=null) {
      findNavController().navigate(
        FragmentKalenderDirections.actionFragmentKalenderToFragmentVideoDay(day)
      )
    }

  }

}