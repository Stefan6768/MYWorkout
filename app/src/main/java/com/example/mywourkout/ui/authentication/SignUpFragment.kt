package com.example.mywourkout.ui.authentication

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
import com.example.mywourkout.databinding.FragmentSignupBinding
import com.example.mywourkout.ui.FragmentZweiDirections
import com.example.mywourkout.ui.MainViewModel

class SignUpFragment : Fragment() {

  private val viewModel: MainViewModel by activityViewModels()

  private lateinit var binding: FragmentSignupBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.signupCancelButton.setOnClickListener {
      viewModel.anonymLogin()
    }

    binding.signupSignupButton.setOnClickListener {
      signUp()
    }

    viewModel.currentUser.observe(
      viewLifecycleOwner,
      Observer {
        if (it != null) {
          findNavController().navigate(R.id.startFragment)
        }
      }
    )
  }

  private fun signUp() {
    val email = binding.signupEmail.text.toString()
    val password = binding.signupPassword.text.toString()

    if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
      viewModel.signup(email, password)
    }
  }
}

