package com.agentrediska.hardwarestore.presentation.categoryfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.app.HardwareStoreApplication
import com.agentrediska.hardwarestore.databinding.FragmentCategoriesBinding
import com.agentrediska.hardwarestore.presentation.categoryfragment.recyclerview.CategoryAdapter
import javax.inject.Inject

class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!
    private val categoryAdapter = CategoryAdapter()

    @Inject
    lateinit var vmFactory: CategoriesViewModelFactory
    private val vm: CategoriesViewModel by viewModels{
        vmFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (context?.applicationContext as HardwareStoreApplication).appComponent.inject(this)

        vm.allCategoryLive.observe( this, {
            categoryAdapter.addAllCategory(it)
        })

        vm.getAllCategoryFromSQLite()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCategoriesBinding.bind(view)
        binding.btnSaveCategory.setOnClickListener {
         //   val newIdCategory = binding.editIdCategory.text.toString()
          //  val newNameCategory = binding.editNameCategory.text.toString()
          //  vm.setCategoryToSQLite(idCategory = newIdCategory, nameCategory = newNameCategory)

            /*Add test data to SQLite*/
            for( i in 1..15) {
                vm.setCategoryToSQLite(idCategory = i.toString(), nameCategory = "Test name $i")
            }
            /*Add test data to SQLite*/
        }

        binding.btnShowCategory.setOnClickListener {
            vm.getCategoryFromSQLite()
            vm.getAllCategoryFromSQLite()
        }

        binding.btnNextFragment.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_categoriesFragment_to_preCategoriesFragment)

        }

        binding.apply {
            categoryList.layoutManager = GridLayoutManager(requireContext(), 2)
            categoryList.adapter = categoryAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}