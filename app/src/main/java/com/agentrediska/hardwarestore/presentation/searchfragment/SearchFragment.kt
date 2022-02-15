package com.agentrediska.hardwarestore.presentation.searchfragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.FragmentSearchBinding


class SearchFragment : Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind( view)

        binding.searchEditText.requestFocus()
        showSoftKeyboard(binding.searchEditText)
    }

    fun showSoftKeyboard(view: View) {
        if(view.requestFocus()){
            val imm: InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}