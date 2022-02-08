package com.agentrediska.hardwarestore.presentation.productfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.app.HardwareStoreApplication
import com.agentrediska.hardwarestore.databinding.FragmentProductsBinding
import com.agentrediska.hardwarestore.presentation.ViewModelFactory
import com.agentrediska.hardwarestore.presentation.precategoryfragment.PreCategoriesFragmentArgs
import javax.inject.Inject

class ProductsFragment : Fragment( R.layout.fragment_products) {

    private val args by lazy {
        arguments?.let {
            PreCategoriesFragmentArgs.fromBundle(it)
        }
    }

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val vm: ProductViewModel by viewModels{
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (context?.applicationContext as HardwareStoreApplication).appComponent.inject(this)

        vm.allProductLD.observe( this, {
            //изменение списка
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProductsBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}