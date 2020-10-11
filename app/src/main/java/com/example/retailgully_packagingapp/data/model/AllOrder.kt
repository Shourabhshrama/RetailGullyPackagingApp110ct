package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllOrder(
    @SerializedName("id")
    @Expose
    var id: String ,
    @SerializedName("expense_name")
    @Expose
    var expense_name: String ,
    @SerializedName("created_at")
    @Expose
    var created_at: String ,
    @SerializedName("updated_at")
    @Expose
    var updated_at: String

)