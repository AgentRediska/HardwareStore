package com.agentrediska.hardwarestore.presentation.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.FragmentMainBinding

import android.content.Intent
import android.net.Uri
import androidx.navigation.fragment.findNavController


class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind( view)

        binding.searchContainer.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToSearchFragment()
            findNavController().navigate( action)
        }
    }
}