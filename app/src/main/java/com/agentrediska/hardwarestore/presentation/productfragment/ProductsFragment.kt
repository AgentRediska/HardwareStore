package com.agentrediska.hardwarestore.presentation.productfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.app.HardwareStoreApplication
import com.agentrediska.hardwarestore.databinding.FragmentProductsBinding
import com.agentrediska.hardwarestore.domain.model.PreCategory
import com.agentrediska.hardwarestore.domain.model.Product
import com.agentrediska.hardwarestore.presentation.ViewModelFactory
import com.agentrediska.hardwarestore.presentation.precategoryfragment.PreCategoriesFragmentArgs
import com.agentrediska.hardwarestore.presentation.productfragment.recyclerview.ProductAdapter
import javax.inject.Inject

class ProductsFragment : Fragment( R.layout.fragment_products) {

    private val args by lazy {
        arguments?.let {
            ProductsFragmentArgs.fromBundle(it)
        }
    }

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private val productAdapter = ProductAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val vm: ProductViewModel by viewModels{
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (context?.applicationContext as HardwareStoreApplication).appComponent.inject(this)

        vm.allProductLD.observe( this, {
            productAdapter.replaceProductsList( newProductsList = it)
        })

        args?.let {
            vm.getAllProductByPreCategoryId(it.idPreCategory)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProductsBinding.bind(view)

        binding.btnSaveProducts.setOnClickListener {
            for( i in 1..15) {
                args?.let {
                    val product = Product( i, it.idPreCategory, "Test productName $i",
                        "32222", 2222, "Zoloto")
                    vm.setProduct(product)
                }
            }
        }

        binding.textPreCategoryInfo.text = "${args?.idPreCategory} / ${args?.namePreCategory}"

        binding.apply {
            productsList.layoutManager = GridLayoutManager( requireContext(), 2)
            productsList.adapter = productAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}