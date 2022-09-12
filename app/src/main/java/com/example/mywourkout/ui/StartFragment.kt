package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentStartBinding

class StartFragment : Fragment() {

  private lateinit var binding: FragmentStartBinding

  private val viewModel: MainViewModel by activityViewModels()

  private lateinit var userMail: String


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    binding.startButton.setOnClickListener {
      findNavController().navigate(StartFragmentDirections.actionStartFragmentToFragmentEins())
      
    }

  viewModel.currentUser.observe(
      viewLifecycleOwner,
      Observer {
        if (it == null) {
          findNavController().navigate(R.id.loginFragment)
        } else {
          if (viewModel.guest == true ) {
            binding.itemText.text = "Hello Gast! Nice to see you :)"
          } else {
            userMail = it.email.toString()
            binding.itemText.text = "Hello $userMail! Nice to see you :)"
          }

        }
      }
    )

    binding.logoutButton.setOnClickListener{
      viewModel.logout()
    }
  }
}