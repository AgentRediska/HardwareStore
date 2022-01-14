package com.agentrediska.hardwarestore.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.agentrediska.hardwarestore.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesBinding.inflate(inflater,container, false )
        val view = binding.root

        binding.btnSaveCategory.setOnClickListener {
            val newIdCategory = binding.editIdCategory.text.toString()
            val newNameCategory = binding.editNameCategory.text.toString()
            vm.setCategory(idCategory = newIdCategory, nameCategory = newNameCategory)
        }

        binding.btnShowCategory.setOnClickListener {
          vm.getCategory()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}