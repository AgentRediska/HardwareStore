package com.agentrediska.hardwarestore.presentation.mainnavigation.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.FragmentMainBinding
import android.widget.Toast

import com.agentrediska.hardwarestore.presentation.mainnavigation.MainActivity

import android.content.Intent
import android.net.Uri

import android.text.TextUtils


class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind( view)

        binding.firstPhoneNumberText.setOnClickListener { actionDial( it) }

        binding.secondPhoneNumberText.setOnClickListener { actionDial(it) }
    }

    fun actionDial( view: View) {
        var phone ="tel:"
        when(view) {
            binding.firstPhoneNumberText -> phone += binding.firstPhoneNumberText.text
            binding.secondPhoneNumberText -> phone += binding.secondPhoneNumberText.text
        }
        startActivity( Intent(Intent.ACTION_DIAL, Uri.parse(phone)))
    }
}