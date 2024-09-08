package com.example.technicalchallenge.ui.products.list_products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.technicalchallenge.databinding.FragmentListProductsBinding
import com.example.technicalchallenge.ui.products.adapters.ListProductsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListProductsFragment : Fragment() {

    private val binding by lazy {
        FragmentListProductsBinding.inflate(layoutInflater)
            .apply { lifecycleOwner = this@ListProductsFragment }
    }

    private val viewModel: ListProductsViewModel by viewModels()
    private lateinit var navigation: NavController
    private lateinit var recyclerAdapter: ListProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation = view.findNavController()
        binding.viewModel = viewModel
        setUpRecycler()
    }

    private fun setUpRecycler(){
        recyclerAdapter = ListProductsAdapter(emptyList()){
            product ->
            Toast.makeText(requireContext(), product.id.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.rvProducts.adapter = recyclerAdapter
    }
}