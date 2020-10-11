package com.example.retailgully_packagingapp.data.model.order_response

import com.example.retailgully_packagingapp.data.model.UserOrder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OrderDetailResponse (@SerializedName("status")
                                @Expose
                                var status: Boolean,
                                @SerializedName("orderItem")
                                @Expose
                                var data: ArrayList<OrderItem>?=null,
                                @SerializedName("message")
                                @Expose
                                var message: String)