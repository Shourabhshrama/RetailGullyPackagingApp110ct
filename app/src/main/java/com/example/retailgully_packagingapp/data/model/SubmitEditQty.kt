package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SubmitEditQty (@SerializedName("id")
                      @Expose
                      var id: Int,
                     @SerializedName("status")
                      @Expose
                      var status: Int)