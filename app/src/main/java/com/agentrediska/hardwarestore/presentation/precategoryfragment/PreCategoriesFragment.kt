package com.agentrediska.hardwarestore.presentation.precategoryfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.GridLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.app.HardwareStoreApplication
import com.agentrediska.hardwarestore.databinding.FragmentPreCategoriesBinding
import com.agentrediska.hardwarestore.presentation.precategoryfragment.recyclerview.PreCategoryAdapter

class PreCategoriesFragment : Fragment(R.layout.fragment_pre_categories) {

    private val preCategoryAdapter = PreCategoryAdapter()

    private var _binding: FragmentPreCategoriesBinding? = null
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
        _binding = FragmentPreCategoriesBinding.bind(view)

        binding.btnSave.setOnClickListener {

        }

        binding.apply {
            preCategoriesList.layoutManager = GridLayoutManager( requireContext(), 2)
            preCategoriesList.adapter = preCategoryAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}