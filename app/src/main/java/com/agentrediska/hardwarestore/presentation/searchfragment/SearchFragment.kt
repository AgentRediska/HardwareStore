package com.agentrediska.hardwarestore.presentation.searchfragment

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.FragmentSearchBinding
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.agentrediska.hardwarestore.presentation.catalognavigation.productfragment.ProductsFragmentDirections


class SearchFragment : Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind( view)

        binding.imageBackToCategories.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToCategoriesFragment()
            findNavController().navigate( action)
        }

        binding.searchEditText.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    actionToProductsFragment( searchText = binding.searchEditText.text.toString())
                    return true
                }
                return false
            }
        })
        binding.searchEditText.requestFocus()
        showSoftKeyboard(binding.searchEditText)
    }

   private fun showSoftKeyboard(view: View) {
        if(view.requestFocus()){
            val imm: InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun actionToProductsFragment( searchText: String) {
            val action = SearchFragmentDirections.
            actionSearchFragmentToProductsFragment( idPreCategory = 0, namePreCategory = searchText)
            findNavController().navigate( action)
        }
}