package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserOrder(
    @SerializedName("customer_id")
    @Expose
    var customer_id: String ,
    @SerializedName("customer_name")
    @Expose
    var customer_name: String ,
    @SerializedName("email")
    @Expose
    var email: String ,
    @SerializedName("order_id")
    @Expose
    var order_id: String

)