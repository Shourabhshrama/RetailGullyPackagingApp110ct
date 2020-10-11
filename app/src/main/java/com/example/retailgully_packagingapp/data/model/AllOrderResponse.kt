package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllOrderResponse( @SerializedName("status")
                             @Expose
                             var ack: Int,
                             @SerializedName("totalOrder")
                             @Expose
                             var totalOrder: Int,
                             @SerializedName("msg")
                             @Expose
                             var message: String
)