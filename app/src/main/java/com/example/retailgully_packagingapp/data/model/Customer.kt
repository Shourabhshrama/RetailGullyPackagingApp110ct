package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("name")
    @Expose
    var name: String ,
    @SerializedName("qty")
    @Expose
    var qty: String ,
    @SerializedName("order_item_id")
    @Expose
    var order_item_id: String ,
    @SerializedName("order_limit")
    @Expose
    var order_limit: String

)