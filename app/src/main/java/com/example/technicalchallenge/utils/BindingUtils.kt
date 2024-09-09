package com.example.technicalchallenge.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.technicalchallenge.R
import com.example.technicalchallenge.domain.model.product.ProductModel
import com.example.technicalchallenge.ui.products.adapters.ListProductsAdapter
import com.example.technicalchallenge.ui.products.list_products.ListProductsViewModel.Companion.FIRST_TYPE
import com.example.technicalchallenge.ui.products.list_products.ListProductsViewModel.Companion.SECOND_TYPE
import com.example.technicalchallenge.ui.products.list_products.ListProductsViewModel.Companion.THIRD_TYPE

@BindingAdapter("items", "textFilter","order")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    items: List<ProductModel>,
    textFilter: String,
    order: Int
) {
    val adapter = recyclerView.adapter as? ListProductsAdapter
    if(textFilter.isEmpty()){
        when(order){
            FIRST_TYPE -> adapter?.updateItems(items)
            SECOND_TYPE -> adapter?.updateItems(items.sortedBy { product -> product.price })
            THIRD_TYPE -> adapter?.updateItems(items.sortedByDescending { product -> product.price })
        }
    }
    else {
        val itemsFiltered = items.filter { text -> text.title.contains(textFilter, true) }
        when(order){
            FIRST_TYPE -> adapter?.updateItems(itemsFiltered)
            SECOND_TYPE -> adapter?.updateItems(itemsFiltered.sortedBy { product -> product.price })
            THIRD_TYPE -> adapter?.updateItems(itemsFiltered.sortedByDescending { product -> product.price })
        }
    }
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String){
    Glide.with(context)
        .load(url)
        .error(R.drawable.empty)
        .into(this)
}

@BindingAdapter("price")
fun TextView.setPrice(price: Double) {
    text = context.getString(R.string.price_format,price.toString())
}

@BindingAdapter("showLoading")
fun View.showLoading(isShow: Boolean){
    this.isVisible = isShow
}

