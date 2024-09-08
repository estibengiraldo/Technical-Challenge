package com.example.technicalchallenge.ui.products.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.technicalchallenge.R
import com.example.technicalchallenge.databinding.ItemProductBinding
import com.example.technicalchallenge.domain.model.product.ProductModel

class ListProductsAdapter(private var itemList: List<ProductModel>, private var clickListener: ((product: ProductModel) -> Unit)? ) :
    RecyclerView.Adapter<ListProductsAdapter.ProductViewHolder>() {

    private lateinit var context : Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    class ProductViewHolder(val binding : ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductModel, clickListener: ((product: ProductModel) -> Unit)?, context: Context) {
            binding.tvTitle.text = item.title
            binding.tvPrice.text = "S/ ${item.price}"
            Glide.with(context)
                .load(item.images)
                .error(R.drawable.empty)
                .into(binding.ivProduct)
            binding.clItemContainer.setOnClickListener {
                clickListener?.invoke(item)
            }
        }

        companion object{
            fun from(parent : ViewGroup) : ProductViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemProductBinding.inflate(inflater,parent,false)
                return  ProductViewHolder(binding)
            }
        }
    }

    fun updateItems(newItemList: List<ProductModel>) {
        itemList = newItemList
        notifyDataSetChanged() // Refresh the RecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder.from(parent)

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(itemList[position], clickListener, context)
    }

    override fun getItemCount() = itemList.size
}