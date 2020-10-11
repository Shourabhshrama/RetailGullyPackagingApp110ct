package com.example.retailgully_packagingapp.data.model.order_response

import com.example.retailgully_packagingapp.data.model.UserOrder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OrderItem (@SerializedName("id")
                      @Expose
                      var id: String,
                      @SerializedName("sku")
                      @Expose
                      var sku: String,
                      @SerializedName("type")
                      @Expose
                      var type: String,
                      @SerializedName("name")
                      @Expose
                      var name: String,
                      @SerializedName("coupon_code")
                      @Expose
                      var coupon_code: String,
                      @SerializedName("weight")
                      @Expose
                      var weight: String,
                      @SerializedName("total_weight")
                      @Expose
                      var total_weight: String,
                      @SerializedName("qty_ordered")
                      @Expose
                      var qty_ordered: String,
                      @SerializedName("qty_shipped")
                      @Expose
                      var qty_shipped: String,
                      @SerializedName("qty_invoiced")
                      @Expose
                      var qty_invoiced: String,
                      @SerializedName("qty_canceled")
                      @Expose
                      var qty_canceled: String,
                      @SerializedName("qty_refunded")
                      @Expose
                      var qty_refunded: String,
                      @SerializedName("price")
                      @Expose
                      var price: String,
                      @SerializedName("base_price")
                      @Expose
                      var base_price: String,
                      @SerializedName("total")
                      @Expose
                      var total: String,
                      @SerializedName("base_total")
                      @Expose
                      var base_total: String,
                      @SerializedName("total_invoiced")
                      @Expose
                      var total_invoiced: String,
                      @SerializedName("base_total_invoiced")
                      @Expose
                      var base_total_invoiced: String,
                      @SerializedName("amount_refunded")
                      @Expose
                      var amount_refunded: String,
                      @SerializedName("base_amount_refunded")
                      @Expose
                      var base_amount_refunded: String,
                      @SerializedName("discount_amount")
                      @Expose
                      var discount_amount: String,
                      @SerializedName("base_discount_amount")
                      @Expose
                      var base_discount_amount: String,
                      @SerializedName("discount_invoiced")
                      @Expose
                      var discount_invoiced: String,
                      @SerializedName("base_discount_invoiced")
                      @Expose
                      var base_discount_invoiced: String,
                      @SerializedName("discount_refunded")
                      @Expose
                      var discount_refunded: String,
                      @SerializedName("base_discount_refunded")
                      @Expose
                      var base_discount_refunded: String,
                      @SerializedName("tax_percent")
                      @Expose
                      var tax_percent: String,
                      @SerializedName("tax_amount")
                      @Expose
                      var tax_amount: String,
                      @SerializedName("base_tax_amount")
                      @Expose
                      var base_tax_amount: String,
                      @SerializedName("tax_amount_invoiced")
                      @Expose
                      var tax_amount_invoiced: String,
                      @SerializedName("base_tax_amount_invoiced")
                      @Expose
                      var base_tax_amount_invoiced: String,
                      @SerializedName("tax_amount_refunded")
                      @Expose
                      var tax_amount_refunded: String,
                      @SerializedName("base_tax_amount_refunded")
                      @Expose
                      var base_tax_amount_refunded: String, @SerializedName("product_id")
                      @Expose
                      var product_id: String, @SerializedName("product_type")
                      @Expose
                      var product_type: String, @SerializedName("order_id")
                      @Expose
                      var order_id: String, @SerializedName("parent_id")
                      @Expose
                      var parent_id: String,@SerializedName("additional")
                      @Expose
                      var additional: String,@SerializedName("created_at")
                      @Expose
                      var created_at: String,@SerializedName("updated_at")
                      @Expose
                      var updated_at: String,@SerializedName("status")
                      @Expose
                      var status: String,@SerializedName("id2")
                      @Expose
                      var id2: String,

                      @SerializedName("assignItemList")
                      @Expose
                      var assignItemList: ArrayList<AssignItem>,




                      @SerializedName("status2")
                      @Expose
                      var status2: String)