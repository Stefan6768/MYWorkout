package com.example.mywourkout.ui.authentication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentLoginBinding
import com.example.mywourkout.ui.MainViewModel

/**
 * LoginFragment enthält das Login UI
 */
class LoginFragment : Fragment() {

  private lateinit var binding: FragmentLoginBinding

  private val viewModel: MainViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.loginSignupButton.setOnClickListener {
      findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
    }

    binding.loginButton.setOnClickListener {
      val email = binding.loginEmailEdit.text.toString()
      val password = binding.editTextTextPassword.text.toString()
      if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
        viewModel.login(email, password)
      }
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
}
