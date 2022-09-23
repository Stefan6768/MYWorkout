package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentPlayerBinding


class FragmentPlayer : Fragment() {

  private lateinit var binding: FragmentPlayerBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
   super.onViewCreated(view, savedInstanceState)
   // lifecycle.addObserver(binding.youtubePlayerView)

    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }


    // binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
    //   override fun onReady(youTubePlayer: YouTubePlayer) {
    //     val videoId = "1f8yoFFdkcY"
    //    youTubePlayer.loadVideo(videoId, 0f)
    //   }
    // })

  }

}