package com.agentrediska.hardwarestore.presentation.categoryfragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.FragmentCategoriesBinding
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.presentation.categoryfragment.recyclerview.CategoryAdapter

class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!
    private val categoryAdapter = CategoryAdapter()

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

        vm.allCategoryLive.observe( this, {
            categoryAdapter.addAllCategory(it)
        })

        vm.getAllCategoryFromSQLite()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCategoriesBinding.bind(view)
        binding.btnSaveCategory.setOnClickListener {
            val newIdCategory = binding.editIdCategory.text.toString()
            val newNameCategory = binding.editNameCategory.text.toString()
            vm.setCategoryToSQLite(idCategory = newIdCategory, nameCategory = newNameCategory)
        }

        binding.btnShowCategory.setOnClickListener {
            vm.getCategoryFromSQLite()
            vm.getAllCategoryFromSQLite()
        }

        binding.apply {
            categoryList.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.categoryList.adapter = categoryAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}