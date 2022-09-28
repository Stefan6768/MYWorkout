package com.example.mywourkout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mywourkout.R
import com.example.mywourkout.databinding.FragmentEditPersdatenBinding
import java.util.*
import kotlin.collections.ArrayList

class FragmentEditPersdaten : Fragment() {

  private lateinit var binding: FragmentEditPersdatenBinding
  private val viewModel: MainViewModel by activityViewModels()


  private var geschlechtid = ""
  private var gewichtid = ""
  private var groesseid = ""
  private var alterid = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_persdaten, container, false)

    binding.lifecycleOwner = this.viewLifecycleOwner

    return binding.root
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)



    binding.returnButton.setOnClickListener {
      findNavController().navigateUp()
    }

    val spinner : Spinner = view.findViewById(R.id.geschlecht_spinner)




      val geschlechtsListe: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
          *resources.getStringArray(R.array.geschlecht_array)
        )
      )
      ArrayAdapter.createFromResource (this.requireContext(), R.array.geschlecht_array, android.R.layout.simple_spinner_item)

        .also {adapter ->

          adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
          spinner.adapter = adapter
        }



      binding.geschlechtSpinner
        .onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
          geschlechtid = geschlechtsListe[position]
        }

        override fun onNothingSelected(parent: AdapterView<*>) {

        }
      }


    binding.saveButton.setOnClickListener {
      groesseid = binding.editGroesseEdit.text.toString()
      gewichtid = binding.editGewichtEdit.text.toString()
      alterid = binding.editAlterEdit.text.toString()
      findNavController().navigate(
        FragmentEditPersdatenDirections.actionFragmentEditPersdatenToFragmentSaveUser(
          geschlechtid, groesseid, gewichtid, alterid
        )
      )
    }


  }
}