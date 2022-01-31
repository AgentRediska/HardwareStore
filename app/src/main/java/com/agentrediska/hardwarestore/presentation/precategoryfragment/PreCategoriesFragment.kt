package com.agentrediska.hardwarestore.presentation.precategoryfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.app.HardwareStoreApplication
import com.agentrediska.hardwarestore.databinding.PreCategoryFragmentBinding

class PreCategoriesFragment : Fragment(R.layout.pre_category_fragment) {

    private var _binding: PreCategoryFragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModelFactory: PreCategoriesViewModelFactory
    private val vm: PreCategoriesViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as HardwareStoreApplication).appComponent.inject( this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = PreCategoryFragmentBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}