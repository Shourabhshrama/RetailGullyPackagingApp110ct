package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserOrderResponse(@SerializedName("status")
                             @Expose
                             var ack: Int,
                             @SerializedName("data")
                             @Expose
                             var data: ArrayList<UserOrder>?=null,
                             @SerializedName("message")
                             @Expose
                             var message: String
)