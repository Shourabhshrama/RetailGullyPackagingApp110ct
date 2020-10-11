package com.example.retailgully_packagingapp.data.model.order_response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderResponse implements Serializable, Parcelable
{

    @SerializedName("orderDetail")
    @Expose
    private OrderDetail orderDetail;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Boolean status;
    public final static Parcelable.Creator<OrderResponse> CREATOR = new Creator<OrderResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OrderResponse createFromParcel(Parcel in) {
            return new OrderResponse(in);
        }

        public OrderResponse[] newArray(int size) {
            return (new OrderResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4259401156800023294L;

    protected OrderResponse(Parcel in) {
        this.orderDetail = ((OrderDetail) in.readValue((OrderDetail.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public OrderResponse() {
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(orderDetail);
        dest.writeValue(message);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}