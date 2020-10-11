package com.example.retailgully_packagingapp.data.model.order_response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coupon_code")
    @Expose
    private Object couponCode;
    @SerializedName("weight")
    @Expose
    private Object weight;
    @SerializedName("total_weight")
    @Expose
    private String totalWeight;
    @SerializedName("qty_ordered")
    @Expose
    private Integer qtyOrdered;
    @SerializedName("qty_shipped")
    @Expose
    private Integer qtyShipped;
    @SerializedName("qty_invoiced")
    @Expose
    private Integer qtyInvoiced;
    @SerializedName("qty_canceled")
    @Expose
    private Integer qtyCanceled;
    @SerializedName("qty_refunded")
    @Expose
    private Integer qtyRefunded;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("base_price")
    @Expose
    private String basePrice;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("base_total")
    @Expose
    private String baseTotal;
    @SerializedName("total_invoiced")
    @Expose
    private String totalInvoiced;
    @SerializedName("base_total_invoiced")
    @Expose
    private String baseTotalInvoiced;
    @SerializedName("amount_refunded")
    @Expose
    private String amountRefunded;
    @SerializedName("base_amount_refunded")
    @Expose
    private String baseAmountRefunded;
    @SerializedName("discount_percent")
    @Expose
    private String discountPercent;
    @SerializedName("discount_amount")
    @Expose
    private String discountAmount;
    @SerializedName("base_discount_amount")
    @Expose
    private String baseDiscountAmount;
    @SerializedName("discount_invoiced")
    @Expose
    private String discountInvoiced;
    @SerializedName("base_discount_invoiced")
    @Expose
    private String baseDiscountInvoiced;
    @SerializedName("discount_refunded")
    @Expose
    private String discountRefunded;
    @SerializedName("base_discount_refunded")
    @Expose
    private String baseDiscountRefunded;
    @SerializedName("tax_percent")
    @Expose
    private String taxPercent;
    @SerializedName("tax_amount")
    @Expose
    private String taxAmount;
    @SerializedName("base_tax_amount")
    @Expose
    private String baseTaxAmount;
    @SerializedName("tax_amount_invoiced")
    @Expose
    private String taxAmountInvoiced;
    @SerializedName("base_tax_amount_invoiced")
    @Expose
    private String baseTaxAmountInvoiced;
    @SerializedName("tax_amount_refunded")
    @Expose
    private String taxAmountRefunded;
    @SerializedName("base_tax_amount_refunded")
    @Expose
    private String baseTaxAmountRefunded;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("order_id")
    @Expose
    private Integer orderId;
    @SerializedName("parent_id")
    @Expose
    private Object parentId;
    @SerializedName("additional")
    @Expose
    private String additional;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("child")
    @Expose
    private Child child;
    public final static Parcelable.Creator<Item> CREATOR = new Creator<Item>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return (new Item[size]);
        }

    }
            ;
    private final static long serialVersionUID = -901067383135880890L;

    protected Item(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sku = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.couponCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.weight = ((Object) in.readValue((Object.class.getClassLoader())));
        this.totalWeight = ((String) in.readValue((String.class.getClassLoader())));
        this.qtyOrdered = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.qtyShipped = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.qtyInvoiced = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.qtyCanceled = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.qtyRefunded = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.price = ((String) in.readValue((String.class.getClassLoader())));
        this.basePrice = ((String) in.readValue((String.class.getClassLoader())));
        this.total = ((String) in.readValue((String.class.getClassLoader())));
        this.baseTotal = ((String) in.readValue((String.class.getClassLoader())));
        this.totalInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.baseTotalInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.amountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.baseAmountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.discountPercent = ((String) in.readValue((String.class.getClassLoader())));
        this.discountAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.baseDiscountAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.discountInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.baseDiscountInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.discountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.baseDiscountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.taxPercent = ((String) in.readValue((String.class.getClassLoader())));
        this.taxAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.baseTaxAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.taxAmountInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.baseTaxAmountInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.taxAmountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.baseTaxAmountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.productId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.productType = ((String) in.readValue((String.class.getClassLoader())));
        this.orderId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.parentId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.additional = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.child = ((Child) in.readValue((Child.class.getClassLoader())));
    }

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(Object couponCode) {
        this.couponCode = couponCode;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(Integer qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public Integer getQtyShipped() {
        return qtyShipped;
    }

    public void setQtyShipped(Integer qtyShipped) {
        this.qtyShipped = qtyShipped;
    }

    public Integer getQtyInvoiced() {
        return qtyInvoiced;
    }

    public void setQtyInvoiced(Integer qtyInvoiced) {
        this.qtyInvoiced = qtyInvoiced;
    }

    public Integer getQtyCanceled() {
        return qtyCanceled;
    }

    public void setQtyCanceled(Integer qtyCanceled) {
        this.qtyCanceled = qtyCanceled;
    }

    public Integer getQtyRefunded() {
        return qtyRefunded;
    }

    public void setQtyRefunded(Integer qtyRefunded) {
        this.qtyRefunded = qtyRefunded;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getBaseTotal() {
        return baseTotal;
    }

    public void setBaseTotal(String baseTotal) {
        this.baseTotal = baseTotal;
    }

    public String getTotalInvoiced() {
        return totalInvoiced;
    }

    public void setTotalInvoiced(String totalInvoiced) {
        this.totalInvoiced = totalInvoiced;
    }

    public String getBaseTotalInvoiced() {
        return baseTotalInvoiced;
    }

    public void setBaseTotalInvoiced(String baseTotalInvoiced) {
        this.baseTotalInvoiced = baseTotalInvoiced;
    }

    public String getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(String amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public String getBaseAmountRefunded() {
        return baseAmountRefunded;
    }

    public void setBaseAmountRefunded(String baseAmountRefunded) {
        this.baseAmountRefunded = baseAmountRefunded;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getBaseDiscountAmount() {
        return baseDiscountAmount;
    }

    public void setBaseDiscountAmount(String baseDiscountAmount) {
        this.baseDiscountAmount = baseDiscountAmount;
    }

    public String getDiscountInvoiced() {
        return discountInvoiced;
    }

    public void setDiscountInvoiced(String discountInvoiced) {
        this.discountInvoiced = discountInvoiced;
    }

    public String getBaseDiscountInvoiced() {
        return baseDiscountInvoiced;
    }

    public void setBaseDiscountInvoiced(String baseDiscountInvoiced) {
        this.baseDiscountInvoiced = baseDiscountInvoiced;
    }

    public String getDiscountRefunded() {
        return discountRefunded;
    }

    public void setDiscountRefunded(String discountRefunded) {
        this.discountRefunded = discountRefunded;
    }

    public String getBaseDiscountRefunded() {
        return baseDiscountRefunded;
    }

    public void setBaseDiscountRefunded(String baseDiscountRefunded) {
        this.baseDiscountRefunded = baseDiscountRefunded;
    }

    public String getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(String taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getBaseTaxAmount() {
        return baseTaxAmount;
    }

    public void setBaseTaxAmount(String baseTaxAmount) {
        this.baseTaxAmount = baseTaxAmount;
    }

    public String getTaxAmountInvoiced() {
        return taxAmountInvoiced;
    }

    public void setTaxAmountInvoiced(String taxAmountInvoiced) {
        this.taxAmountInvoiced = taxAmountInvoiced;
    }

    public String getBaseTaxAmountInvoiced() {
        return baseTaxAmountInvoiced;
    }

    public void setBaseTaxAmountInvoiced(String baseTaxAmountInvoiced) {
        this.baseTaxAmountInvoiced = baseTaxAmountInvoiced;
    }

    public String getTaxAmountRefunded() {
        return taxAmountRefunded;
    }

    public void setTaxAmountRefunded(String taxAmountRefunded) {
        this.taxAmountRefunded = taxAmountRefunded;
    }

    public String getBaseTaxAmountRefunded() {
        return baseTaxAmountRefunded;
    }

    public void setBaseTaxAmountRefunded(String baseTaxAmountRefunded) {
        this.baseTaxAmountRefunded = baseTaxAmountRefunded;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(sku);
        dest.writeValue(type);
        dest.writeValue(name);
        dest.writeValue(couponCode);
        dest.writeValue(weight);
        dest.writeValue(totalWeight);
        dest.writeValue(qtyOrdered);
        dest.writeValue(qtyShipped);
        dest.writeValue(qtyInvoiced);
        dest.writeValue(qtyCanceled);
        dest.writeValue(qtyRefunded);
        dest.writeValue(price);
        dest.writeValue(basePrice);
        dest.writeValue(total);
        dest.writeValue(baseTotal);
        dest.writeValue(totalInvoiced);
        dest.writeValue(baseTotalInvoiced);
        dest.writeValue(amountRefunded);
        dest.writeValue(baseAmountRefunded);
        dest.writeValue(discountPercent);
        dest.writeValue(discountAmount);
        dest.writeValue(baseDiscountAmount);
        dest.writeValue(discountInvoiced);
        dest.writeValue(baseDiscountInvoiced);
        dest.writeValue(discountRefunded);
        dest.writeValue(baseDiscountRefunded);
        dest.writeValue(taxPercent);
        dest.writeValue(taxAmount);
        dest.writeValue(baseTaxAmount);
        dest.writeValue(taxAmountInvoiced);
        dest.writeValue(baseTaxAmountInvoiced);
        dest.writeValue(taxAmountRefunded);
        dest.writeValue(baseTaxAmountRefunded);
        dest.writeValue(productId);
        dest.writeValue(productType);
        dest.writeValue(orderId);
        dest.writeValue(parentId);
        dest.writeValue(additional);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(child);
    }

    public int describeContents() {
        return 0;
    }

}
