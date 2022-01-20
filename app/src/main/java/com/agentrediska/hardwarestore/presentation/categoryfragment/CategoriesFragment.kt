package com.agentrediska.hardwarestore.presentation.categoryfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private val vm: CategoriesViewModel by viewModels{
        CategoriesViewModelFactory(context = requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.categoryInfoLive.observe(this, { category ->
            binding.textIdCategory.text = category.id.toString()
            binding.textNameCategory.text = category.name
        })

        vm.correctNewInfoLive.observe( this, { result ->
            if(!result){
                binding.textNameCategory.text = "Incorrect data"
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCategoriesBinding.bind(view)
        findNavController().navigate(R.id.action_categoriesFragment_to_placeholder)
        binding.btnSaveCategory.setOnClickListener {
            val newIdCategory = binding.editIdCategory.text.toString()
            val newNameCategory = binding.editNameCategory.text.toString()
            vm.setCategoryToSQLite(idCategory = newIdCategory, nameCategory = newNameCategory)
        }

        binding.btnShowCategory.setOnClickListener {
            vm.getCategoryFromSQLite()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}