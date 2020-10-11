package com.example.retailgully_packagingapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SubmitEditQtyBase (@SerializedName("items")
                      @Expose
                      var items: ArrayList<SubmitEditQty>)