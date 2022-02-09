package com.agentrediska.hardwarestore.presentation.precategoryfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.GridLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.app.HardwareStoreApplication
import com.agentrediska.hardwarestore.databinding.FragmentPreCategoriesBinding
import com.agentrediska.hardwarestore.domain.model.PreCategory
import com.agentrediska.hardwarestore.presentation.ViewModelFactory
import com.agentrediska.hardwarestore.presentation.categoryfragment.CategoriesFragmentDirections
import com.agentrediska.hardwarestore.presentation.precategoryfragment.recyclerview.PreCategoryAdapter
import javax.inject.Inject

class PreCategoriesFragment : Fragment(R.layout.fragment_pre_categories) {

    private val clickHolder = { id: Int, name: String ->
        print( "$id, $name")
        val action = PreCategoriesFragmentDirections.
        actionPreCategoriesFragmentToProductsFragment(
            idPreCategory = id, namePreCategory = name
        )
        findNavController().navigate(action)
    }

    private val preCategoryAdapter = PreCategoryAdapter( onClickCallback = clickHolder)
    private val args by lazy {
        arguments?.let {
            PreCategoriesFragmentArgs.fromBundle(it)
        }
    }

    private var _binding: FragmentPreCategoriesBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val vm: PreCategoriesViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as HardwareStoreApplication).appComponent.inject( this)

        vm.allPreCategoryLD.observe( this, {
            preCategoryAdapter.replacePreCategoriesList( newPreCategoryList = it)
        })

        args?.let {
            vm.getPreCategoriesByCategoryId(it.idCategory)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPreCategoriesBinding.bind(view)
        binding.btnSave.setOnClickListener {
            /*Add test data to SQLite*/
            for( i in 1..15) {
                args?.let {
                    val preCategory = PreCategory( i, it.idCategory, "Test pName $i")
                    vm.setPreCategory(preCategory)
                }
            }
            /*Add test data to SQLite*/
        }

        binding.textCategoryInfo.text = "${args?.idCategory} / ${args?.nameCategory}"

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