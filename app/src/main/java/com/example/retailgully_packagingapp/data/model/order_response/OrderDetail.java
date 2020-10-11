package com.example.retailgully_packagingapp.data.model.order_response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderDetail implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("increment_id")
    @Expose
    private String incrementId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("channel_name")
    @Expose
    private String channelName;
    @SerializedName("is_guest")
    @Expose
    private Integer isGuest;
    @SerializedName("customer_email")
    @Expose
    private String customerEmail;
    @SerializedName("customer_first_name")
    @Expose
    private String customerFirstName;
    @SerializedName("customer_last_name")
    @Expose
    private String customerLastName;
    @SerializedName("customer_company_name")
    @Expose
    private Object customerCompanyName;
    @SerializedName("customer_vat_id")
    @Expose
    private Object customerVatId;
    @SerializedName("shipping_method")
    @Expose
    private String shippingMethod;
    @SerializedName("shipping_title")
    @Expose
    private String shippingTitle;
    @SerializedName("shipping_description")
    @Expose
    private String shippingDescription;
    @SerializedName("coupon_code")
    @Expose
    private Object couponCode;
    @SerializedName("is_gift")
    @Expose
    private Integer isGift;
    @SerializedName("total_item_count")
    @Expose
    private Integer totalItemCount;
    @SerializedName("total_qty_ordered")
    @Expose
    private Integer totalQtyOrdered;
    @SerializedName("base_currency_code")
    @Expose
    private String baseCurrencyCode;
    @SerializedName("channel_currency_code")
    @Expose
    private String channelCurrencyCode;
    @SerializedName("order_currency_code")
    @Expose
    private String orderCurrencyCode;
    @SerializedName("grand_total")
    @Expose
    private String grandTotal;
    @SerializedName("base_grand_total")
    @Expose
    private String baseGrandTotal;
    @SerializedName("grand_total_invoiced")
    @Expose
    private String grandTotalInvoiced;
    @SerializedName("base_grand_total_invoiced")
    @Expose
    private String baseGrandTotalInvoiced;
    @SerializedName("grand_total_refunded")
    @Expose
    private String grandTotalRefunded;
    @SerializedName("base_grand_total_refunded")
    @Expose
    private String baseGrandTotalRefunded;
    @SerializedName("sub_total")
    @Expose
    private String subTotal;
    @SerializedName("base_sub_total")
    @Expose
    private String baseSubTotal;
    @SerializedName("sub_total_invoiced")
    @Expose
    private String subTotalInvoiced;
    @SerializedName("base_sub_total_invoiced")
    @Expose
    private String baseSubTotalInvoiced;
    @SerializedName("sub_total_refunded")
    @Expose
    private String subTotalRefunded;
    @SerializedName("base_sub_total_refunded")
    @Expose
    private String baseSubTotalRefunded;
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
    @SerializedName("shipping_amount")
    @Expose
    private String shippingAmount;
    @SerializedName("base_shipping_amount")
    @Expose
    private String baseShippingAmount;
    @SerializedName("shipping_invoiced")
    @Expose
    private String shippingInvoiced;
    @SerializedName("base_shipping_invoiced")
    @Expose
    private String baseShippingInvoiced;
    @SerializedName("shipping_refunded")
    @Expose
    private String shippingRefunded;
    @SerializedName("base_shipping_refunded")
    @Expose
    private String baseShippingRefunded;
    @SerializedName("customer_id")
    @Expose
    private Integer customerId;
    @SerializedName("customer_type")
    @Expose
    private String customerType;
    @SerializedName("channel_id")
    @Expose
    private Integer channelId;
    @SerializedName("channel_type")
    @Expose
    private String channelType;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("cart_id")
    @Expose
    private Integer cartId;
    @SerializedName("applied_cart_rule_ids")
    @Expose
    private Object appliedCartRuleIds;
    @SerializedName("shipping_discount_amount")
    @Expose
    private String shippingDiscountAmount;
    @SerializedName("base_shipping_discount_amount")
    @Expose
    private Double baseShippingDiscountAmount;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("store_name")
    @Expose
    private String storeName = null;
    public final static Parcelable.Creator<OrderDetail> CREATOR = new Creator<OrderDetail>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OrderDetail createFromParcel(Parcel in) {
            return new OrderDetail(in);
        }

        public OrderDetail[] newArray(int size) {
            return (new OrderDetail[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2609912943085960404L;

    protected OrderDetail(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.incrementId = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.channelName = ((String) in.readValue((String.class.getClassLoader())));
        this.isGuest = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.customerEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.customerFirstName = ((String) in.readValue((String.class.getClassLoader())));
        this.customerLastName = ((String) in.readValue((String.class.getClassLoader())));
        this.customerCompanyName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.customerVatId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.shippingMethod = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.couponCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isGift = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalItemCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalQtyOrdered = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.baseCurrencyCode = ((String) in.readValue((String.class.getClassLoader())));
        this.channelCurrencyCode = ((String) in.readValue((String.class.getClassLoader())));
        this.orderCurrencyCode = ((String) in.readValue((String.class.getClassLoader())));
        this.grandTotal = ((String) in.readValue((String.class.getClassLoader())));
        this.baseGrandTotal = ((String) in.readValue((String.class.getClassLoader())));
        this.grandTotalInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.baseGrandTotalInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.grandTotalRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.baseGrandTotalRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.subTotal = ((String) in.readValue((String.class.getClassLoader())));
        this.baseSubTotal = ((String) in.readValue((String.class.getClassLoader())));
        this.subTotalInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.baseSubTotalInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.subTotalRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.baseSubTotalRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.discountPercent = ((String) in.readValue((String.class.getClassLoader())));
        this.discountAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.baseDiscountAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.discountInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.baseDiscountInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.discountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.baseDiscountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.taxAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.baseTaxAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.taxAmountInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.baseTaxAmountInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.taxAmountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.baseTaxAmountRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.baseShippingAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.baseShippingInvoiced = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.baseShippingRefunded = ((String) in.readValue((String.class.getClassLoader())));
        this.customerId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.customerType = ((String) in.readValue((String.class.getClassLoader())));
        this.channelId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.channelType = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.cartId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.appliedCartRuleIds = ((Object) in.readValue((Object.class.getClassLoader())));
        this.shippingDiscountAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.baseShippingDiscountAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.items, (Item.class.getClassLoader()));
        this.storeName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OrderDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIncrementId() {
        return incrementId;
    }

    public void setIncrementId(String incrementId) {
        this.incrementId = incrementId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Integer isGuest) {
        this.isGuest = isGuest;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Object getCustomerCompanyName() {
        return customerCompanyName;
    }

    public void setCustomerCompanyName(Object customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
    }

    public Object getCustomerVatId() {
        return customerVatId;
    }

    public void setCustomerVatId(Object customerVatId) {
        this.customerVatId = customerVatId;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingTitle() {
        return shippingTitle;
    }

    public void setShippingTitle(String shippingTitle) {
        this.shippingTitle = shippingTitle;
    }

    public String getShippingDescription() {
        return shippingDescription;
    }

    public void setShippingDescription(String shippingDescription) {
        this.shippingDescription = shippingDescription;
    }

    public Object getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(Object couponCode) {
        this.couponCode = couponCode;
    }

    public Integer getIsGift() {
        return isGift;
    }

    public void setIsGift(Integer isGift) {
        this.isGift = isGift;
    }

    public Integer getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(Integer totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public Integer getTotalQtyOrdered() {
        return totalQtyOrdered;
    }

    public void setTotalQtyOrdered(Integer totalQtyOrdered) {
        this.totalQtyOrdered = totalQtyOrdered;
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public String getChannelCurrencyCode() {
        return channelCurrencyCode;
    }

    public void setChannelCurrencyCode(String channelCurrencyCode) {
        this.channelCurrencyCode = channelCurrencyCode;
    }

    public String getOrderCurrencyCode() {
        return orderCurrencyCode;
    }

    public void setOrderCurrencyCode(String orderCurrencyCode) {
        this.orderCurrencyCode = orderCurrencyCode;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getBaseGrandTotal() {
        return baseGrandTotal;
    }

    public void setBaseGrandTotal(String baseGrandTotal) {
        this.baseGrandTotal = baseGrandTotal;
    }

    public String getGrandTotalInvoiced() {
        return grandTotalInvoiced;
    }

    public void setGrandTotalInvoiced(String grandTotalInvoiced) {
        this.grandTotalInvoiced = grandTotalInvoiced;
    }

    public String getBaseGrandTotalInvoiced() {
        return baseGrandTotalInvoiced;
    }

    public void setBaseGrandTotalInvoiced(String baseGrandTotalInvoiced) {
        this.baseGrandTotalInvoiced = baseGrandTotalInvoiced;
    }

    public String getGrandTotalRefunded() {
        return grandTotalRefunded;
    }

    public void setGrandTotalRefunded(String grandTotalRefunded) {
        this.grandTotalRefunded = grandTotalRefunded;
    }

    public String getBaseGrandTotalRefunded() {
        return baseGrandTotalRefunded;
    }

    public void setBaseGrandTotalRefunded(String baseGrandTotalRefunded) {
        this.baseGrandTotalRefunded = baseGrandTotalRefunded;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getBaseSubTotal() {
        return baseSubTotal;
    }

    public void setBaseSubTotal(String baseSubTotal) {
        this.baseSubTotal = baseSubTotal;
    }

    public String getSubTotalInvoiced() {
        return subTotalInvoiced;
    }

    public void setSubTotalInvoiced(String subTotalInvoiced) {
        this.subTotalInvoiced = subTotalInvoiced;
    }

    public String getBaseSubTotalInvoiced() {
        return baseSubTotalInvoiced;
    }

    public void setBaseSubTotalInvoiced(String baseSubTotalInvoiced) {
        this.baseSubTotalInvoiced = baseSubTotalInvoiced;
    }

    public String getSubTotalRefunded() {
        return subTotalRefunded;
    }

    public void setSubTotalRefunded(String subTotalRefunded) {
        this.subTotalRefunded = subTotalRefunded;
    }

    public String getBaseSubTotalRefunded() {
        return baseSubTotalRefunded;
    }

    public void setBaseSubTotalRefunded(String baseSubTotalRefunded) {
        this.baseSubTotalRefunded = baseSubTotalRefunded;
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

    public String getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(String shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public String getBaseShippingAmount() {
        return baseShippingAmount;
    }

    public void setBaseShippingAmount(String baseShippingAmount) {
        this.baseShippingAmount = baseShippingAmount;
    }

    public String getShippingInvoiced() {
        return shippingInvoiced;
    }

    public void setShippingInvoiced(String shippingInvoiced) {
        this.shippingInvoiced = shippingInvoiced;
    }

    public String getBaseShippingInvoiced() {
        return baseShippingInvoiced;
    }

    public void setBaseShippingInvoiced(String baseShippingInvoiced) {
        this.baseShippingInvoiced = baseShippingInvoiced;
    }

    public String getShippingRefunded() {
        return shippingRefunded;
    }

    public void setShippingRefunded(String shippingRefunded) {
        this.shippingRefunded = shippingRefunded;
    }

    public String getBaseShippingRefunded() {
        return baseShippingRefunded;
    }

    public void setBaseShippingRefunded(String baseShippingRefunded) {
        this.baseShippingRefunded = baseShippingRefunded;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
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

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Object getAppliedCartRuleIds() {
        return appliedCartRuleIds;
    }

    public void setAppliedCartRuleIds(Object appliedCartRuleIds) {
        this.appliedCartRuleIds = appliedCartRuleIds;
    }

    public String getShippingDiscountAmount() {
        return shippingDiscountAmount;
    }

    public void setShippingDiscountAmount(String shippingDiscountAmount) {
        this.shippingDiscountAmount = shippingDiscountAmount;
    }

    public Double getBaseShippingDiscountAmount() {
        return baseShippingDiscountAmount;
    }

    public void setBaseShippingDiscountAmount(Double baseShippingDiscountAmount) {
        this.baseShippingDiscountAmount = baseShippingDiscountAmount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(incrementId);
        dest.writeValue(status);
        dest.writeValue(channelName);
        dest.writeValue(isGuest);
        dest.writeValue(customerEmail);
        dest.writeValue(customerFirstName);
        dest.writeValue(customerLastName);
        dest.writeValue(customerCompanyName);
        dest.writeValue(customerVatId);
        dest.writeValue(shippingMethod);
        dest.writeValue(shippingTitle);
        dest.writeValue(shippingDescription);
        dest.writeValue(couponCode);
        dest.writeValue(isGift);
        dest.writeValue(totalItemCount);
        dest.writeValue(totalQtyOrdered);
        dest.writeValue(baseCurrencyCode);
        dest.writeValue(channelCurrencyCode);
        dest.writeValue(orderCurrencyCode);
        dest.writeValue(grandTotal);
        dest.writeValue(baseGrandTotal);
        dest.writeValue(grandTotalInvoiced);
        dest.writeValue(baseGrandTotalInvoiced);
        dest.writeValue(grandTotalRefunded);
        dest.writeValue(baseGrandTotalRefunded);
        dest.writeValue(subTotal);
        dest.writeValue(baseSubTotal);
        dest.writeValue(subTotalInvoiced);
        dest.writeValue(baseSubTotalInvoiced);
        dest.writeValue(subTotalRefunded);
        dest.writeValue(baseSubTotalRefunded);
        dest.writeValue(discountPercent);
        dest.writeValue(discountAmount);
        dest.writeValue(baseDiscountAmount);
        dest.writeValue(discountInvoiced);
        dest.writeValue(baseDiscountInvoiced);
        dest.writeValue(discountRefunded);
        dest.writeValue(baseDiscountRefunded);
        dest.writeValue(taxAmount);
        dest.writeValue(baseTaxAmount);
        dest.writeValue(taxAmountInvoiced);
        dest.writeValue(baseTaxAmountInvoiced);
        dest.writeValue(taxAmountRefunded);
        dest.writeValue(baseTaxAmountRefunded);
        dest.writeValue(shippingAmount);
        dest.writeValue(baseShippingAmount);
        dest.writeValue(shippingInvoiced);
        dest.writeValue(baseShippingInvoiced);
        dest.writeValue(shippingRefunded);
        dest.writeValue(baseShippingRefunded);
        dest.writeValue(customerId);
        dest.writeValue(customerType);
        dest.writeValue(channelId);
        dest.writeValue(channelType);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(cartId);
        dest.writeValue(appliedCartRuleIds);
        dest.writeValue(shippingDiscountAmount);
        dest.writeValue(baseShippingDiscountAmount);
        dest.writeList(items);
        dest.writeValue(storeName);
    }

    public int describeContents() {
        return 0;
    }

}