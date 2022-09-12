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
import com.example.mywourkout.databinding.Bauch5minBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class FragmentBauch5min : Fragment() {

  private lateinit var binding: Bauch5minBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.bauch_5min, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    lifecycle.addObserver(binding.youtubePlayerView)



    binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
      override fun onReady(youTubePlayer: YouTubePlayer) {
        val videoId = "AOSaOtWtQfc"
        youTubePlayer.loadVideo(videoId, 5f)
      }
    })

   // binding.bauch5minVideo.setOnPreparedListener {mp ->
   //   mp.isLooping = true
   //   mp.setVolume(0f,0f)
   // }

    //val uri = Uri.parse("android.resource://"+ context?.packageName + "/" + R.raw.bauch)
   // binding.bauch5minVideo.setVideoURI(uri)
   // binding.bauch5minVideo.start()

   binding.imageButton.setOnClickListener {
     findNavController().navigateUp()
   }
    }
  }
