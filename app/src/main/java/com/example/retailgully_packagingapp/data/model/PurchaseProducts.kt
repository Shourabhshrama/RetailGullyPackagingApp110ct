package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PurchaseProducts(
    @SerializedName("qty")
    @Expose
    var qty: String ,
    @SerializedName("product_qty_price_id")
    @Expose
    var product_qty_price_id: String ,
    @SerializedName("price")
    @Expose
    var price: String

)