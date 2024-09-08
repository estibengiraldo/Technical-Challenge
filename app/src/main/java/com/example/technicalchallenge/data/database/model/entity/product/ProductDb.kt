package com.example.technicalchallenge.data.database.model.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.technicalchallenge.domain.model.product.ProductModel

@Entity(tableName = "product")
data class ProductDb(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "image")
    val image: String,

) {

    companion object {

        fun fromProductModel(product: ProductModel) = ProductDb(
            product.id,
            product.title,
            product.description,
            product.price,
            product.images
        )
    }

    fun toProductModel(): ProductModel =
        ProductModel(id,title, description,price, image)
}
