package com.example.retailgully_packagingapp.data.model.order_response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AssignItem  (@SerializedName("id")
                        @Expose
                        var id: String,
                        @SerializedName("product_id")
                        @Expose
                        var product_id: String,
                        @SerializedName("order_item_id")
                        @Expose
                        var order_item_id: String,
                        @SerializedName("qty")
                        @Expose
                        var qty: String,
                        @SerializedName("price")
                        @Expose
                        var price: String,
                        @SerializedName("status")
                        @Expose
                        var status: String,
                        @SerializedName("created_at")
                        @Expose
                        var created_at: String,

                        @SerializedName("updated_at")
                        @Expose
                        var updated_at: String)