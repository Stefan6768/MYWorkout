package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentSportvideoBinding
import com.example.mywourkout.data.datamodels.Video
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class FragmentSportVideo : Fragment() {

  private lateinit var binding: FragmentSportvideoBinding

  private val viewModel:MainViewModel by activityViewModels()

  private var video = ""
  private var length = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      video = it.getString("video","")
      length = it.getString("length","")
    }

  }


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sportvideo, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    lifecycle.addObserver(binding.youtubePlayerView)



    binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
      override fun onReady(youTubePlayer: YouTubePlayer) {

        val searchid = video + length

        println("searchid=$searchid")

        //val videoId = resources.getString(searchid.toInt())
        val video: Video? = viewModel.videos.find { it.id == searchid  }
        if (video != null) {
          youTubePlayer.loadVideo("bfohE7qM9pM", 15f)
        }

      }
    })

    binding.imageButton2.setOnClickListener {
      findNavController().navigateUp()
    }

  }
}