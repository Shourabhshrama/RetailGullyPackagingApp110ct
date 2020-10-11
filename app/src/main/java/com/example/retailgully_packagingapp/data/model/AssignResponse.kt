package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AssignResponse(@SerializedName("code")
                             @Expose
                             var code: Int,

                          @SerializedName("message")
                             @Expose
                             var message: String
)