package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AssignProductReponse(
    @SerializedName("status")
    @Expose
    var status: Int,
    @SerializedName("purchase_product_list")
    @Expose
    var purchase_product_list: ArrayList<PurchaseProducts>?=null,
    @SerializedName("customers")
    @Expose
    var customers: ArrayList<Customer>?=null,
    @SerializedName("msg")
    @Expose
    var message: String
)