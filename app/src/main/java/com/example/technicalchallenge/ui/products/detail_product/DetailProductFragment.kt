package com.example.technicalchallenge.ui.products.detail_product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.technicalchallenge.databinding.FragmentDetailProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailProductFragment : Fragment() {

    private val binding by lazy {
        FragmentDetailProductBinding.inflate(layoutInflater)
            .apply { lifecycleOwner = this@DetailProductFragment }
    }

    private val viewModel: DetailProductViewModel by viewModels()
    private lateinit var navigation: NavController

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
        val args: DetailProductFragmentArgs by navArgs()
        init(args.id)
        onClickBack()
    }

    private fun init(id: Int){
        viewModel.getProduct(id)
    }

    private fun onClickBack(){
        binding.ivBack.setOnClickListener {
            navigation.popBackStack()
        }
    }
}