package com.example.mywourkout.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentSaveUserBinding


class FragmentSaveUser : Fragment() {

  private lateinit var binding: FragmentSaveUserBinding

  private var geschlechtid = ""
  private var gewichtid = ""
  private var groesseid = ""
  private var alterid = ""

  private val viewModel: MainViewModel by activityViewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      geschlechtid = it.getString("geschlechtid")!!
      groesseid = it.getString("groesseid")!!
      gewichtid = it.getString("gewichtid")!!
      alterid = it.getString("alterid")!!

      Log.e("test", geschlechtid)

    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(
      inflater,
      R.layout.fragment_save_user,
      container,
      false
    )


    // damit LiveData automatisch observed wird vom layout
    binding.lifecycleOwner = this.viewLifecycleOwner

    // Inflate the layout for this fragment
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }

    binding.userGeschlechtText.text = geschlechtid
    binding.userGroesseText.text = groesseid
    binding.userGewichtText.text = gewichtid
    binding.userAlterText.text = alterid

  }
}