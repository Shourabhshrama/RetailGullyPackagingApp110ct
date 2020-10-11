package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateItemStatusResponse (@SerializedName("success")
                                     @Expose
                                     var success: Boolean,

                                     @SerializedName("message")
                                     @Expose
                                     var message: String)