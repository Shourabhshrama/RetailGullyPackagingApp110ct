package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("total_qty")
    @Expose
    var total_qty: String ,
    @SerializedName("product_name")
    @Expose
    var product_name: String ,
    @SerializedName("product_id")
    @Expose
    var product_id: String ,
    @SerializedName("order_id")
    @Expose
    var order_id: String ,
    @SerializedName("product_type")
    @Expose
    var product_type: String?=null

)