package com.agentrediska.hardwarestore.presentation.productdetailfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.app.HardwareStoreApplication
import com.agentrediska.hardwarestore.databinding.FragmentProductDetailBinding
import com.agentrediska.hardwarestore.presentation.ViewModelFactory
import javax.inject.Inject

class ProductDetailFragment : Fragment(R.layout.fragment_product_detail) {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private val args by lazy {
        arguments?.let {
            //
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val vm: ProductDetailViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as HardwareStoreApplication).appComponent.inject(this)
     //   vm.getProduct(//args)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProductDetailBinding.bind( view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}