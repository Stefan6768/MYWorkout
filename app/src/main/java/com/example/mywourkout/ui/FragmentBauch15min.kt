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
import com.example.mywourkout.databinding.Bauch15minBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class FragmentBauch15min : Fragment() {

  private lateinit var binding: Bauch15minBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.bauch_15min, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    lifecycle.addObserver(binding.youtubePlayerView)



    binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
      override fun onReady(youTubePlayer: YouTubePlayer) {
        val videoId = "https://www.youtube.com/watch?v=D7Bo3BqOCc4"
        youTubePlayer.loadVideo(videoId, 0f)
      }
    })

   // binding.bauch15minVideo.setOnPreparedListener {mp ->
   //   mp.isLooping = true
    //  mp.setVolume(0f,0f)
   // }

   // val uri = Uri.parse("android.resource://"+ context?.packageName + "/" + R.raw.bauch2)
   // binding.bauch15minVideo.setVideoURI(uri)
   // binding.bauch15minVideo.start()

    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }
  }
}