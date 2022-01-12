package com.agentrediska.hardwarestore.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.agentrediska.hardwarestore.data.repository.AllCategoryRepositoryImp
import com.agentrediska.hardwarestore.data.repository.CategoryRepositoryImp
import com.agentrediska.hardwarestore.data.storage.SharedPreferenceStorage
import com.agentrediska.hardwarestore.databinding.FragmentCategoriesBinding
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.usecase.GetAllCategoriesUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategoryUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategoryUseCase

class FragmentCategoriesWithProducts : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private val categoryRepository by lazy { CategoryRepositoryImp(SharedPreferenceStorage(requireContext())) }
    private val allCategoryRepository by lazy { AllCategoryRepositoryImp( requireContext() ) }
    private val getCategoryUseCase by lazy { GetCategoryUseCase(categoryRepository = categoryRepository) }
    private val setCategoryUseCase by lazy { SetCategoryUseCase(categoryRepository = categoryRepository)}
    private val getAllCategoriesUseCase by lazy { GetAllCategoriesUseCase(allCategoryRepository = allCategoryRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesBinding.inflate(inflater,container, false )
        val view = binding.root

        binding.btnSaveCategory.setOnClickListener {
            val newIdCategory = Integer.parseInt( binding.editIdCategory.text.toString() )
            val newNameCategory = binding.editNameCategory.text.toString()
            val result = setCategoryUseCase.setCategory( Category(id = newIdCategory, name = newNameCategory) )
            if(!result){
                binding.textNameCategory.text = "Incorrect data"
            }
        }

        binding.btnShowCategory.setOnClickListener {
          val category = getCategoryUseCase.getCategory()
            binding.textIdCategory.text = category.id.toString()
            binding.textNameCategory.text = category.name
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}