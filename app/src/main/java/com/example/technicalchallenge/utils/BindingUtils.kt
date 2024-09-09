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
            0 -> adapter?.updateItems(items)
            1 -> adapter?.updateItems(items.sortedBy { product -> product.price })
            2 -> adapter?.updateItems(items.sortedByDescending { product -> product.price })
        }
    }
    else {
        val itemsFiltered = items.filter { text -> text.title.contains(textFilter, true) }
        when(order){
            0 -> adapter?.updateItems(itemsFiltered)
            1 -> adapter?.updateItems(itemsFiltered.sortedBy { product -> product.price })
            2 -> adapter?.updateItems(itemsFiltered.sortedByDescending { product -> product.price })
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

