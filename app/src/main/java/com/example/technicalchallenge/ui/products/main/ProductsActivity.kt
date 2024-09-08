package com.example.technicalchallenge.ui.products.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.technicalchallenge.databinding.ActivityProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}