package com.example.mywourkout.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mywourkout.R
import com.example.mywourkout.data.datamodels.Video
import com.example.mywourkout.data.datamodels.VideoList
import com.example.mywourkout.databinding.FragmentKalenderBinding
import com.example.mywourkout.databinding.FragmentVideoDayBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class FragmentVideoDay : Fragment() {

  private lateinit var binding: FragmentVideoDayBinding

  private val viewModel: MainViewModel by activityViewModels()

  private var dayid = ""

  private var videoList = listOf<Video>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (arguments != null) {
      dayid = requireArguments()!!.getString("day").toString()

    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(
      inflater,
      R.layout.fragment_video_day,
      container,
      false
    )
   return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    lifecycle.addObserver(binding.youtubeDayPlayerView)

    videoList = VideoList().loadMyworkout()
    val video = videoList.find { it.tag == dayid }


    binding.youtubeDayPlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
      override fun onReady(youTubePlayer: YouTubePlayer) {

        if (video != null) {
          Log.d(TAG,"video found $video.video")
          youTubePlayer.loadVideo(video.video, 4f)
        }

      }
    })
  }
}
