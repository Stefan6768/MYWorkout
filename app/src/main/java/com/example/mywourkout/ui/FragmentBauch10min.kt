package com.example.mywourkout.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.Bauch10minBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


class FragmentBauch10min : Fragment() {

  private lateinit var binding: Bauch10minBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.bauch_10min, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    lifecycle.addObserver(binding.youtubePlayerView)



    binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
      override fun onReady(youTubePlayer: YouTubePlayer) {
        val videoId = "https://www.youtube.com/watch?v=X_ZJpZgRecI"
        youTubePlayer.loadVideo(videoId, 0f)
      }
    })

    //binding.bauch10minVideo.setOnPreparedListener {mp ->
    //   mp.isLooping = true
    //  mp.setVolume(10f,10f)
    // }

    // val uri = Uri.parse("android.resource://"+ context?.packageName + "/" + R.raw.bauch1)
    //  binding.bauch10minVideo.setVideoURI(uri)
    //  binding.bauch10minVideo.start()

    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }
  }
}