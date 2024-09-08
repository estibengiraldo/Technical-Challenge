package com.example.technicalchallenge.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
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

