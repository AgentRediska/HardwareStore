package com.agentrediska.hardwarestore.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.agentrediska.hardwarestore.data.repository.AllCategoryRepositoryImp
import com.agentrediska.hardwarestore.data.repository.CategoryRepositoryImp
import com.agentrediska.hardwarestore.databinding.FragmentCategoriesBinding
import com.agentrediska.hardwarestore.domain.usecase.GetAllCategoriesUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategoryUseCase

class FragmentCategoriesWithProducts : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private val categoryRepository = CategoryRepositoryImp()
    private val allCategoryRepository = AllCategoryRepositoryImp()
    private val getCategoryUseCase = GetCategoryUseCase(categoryRepository = categoryRepository)
    private val getAllCategoriesUseCase = GetAllCategoriesUseCase(allCategoryRepository = allCategoryRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesBinding.inflate(inflater,container, false )
        val view = binding.root

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}