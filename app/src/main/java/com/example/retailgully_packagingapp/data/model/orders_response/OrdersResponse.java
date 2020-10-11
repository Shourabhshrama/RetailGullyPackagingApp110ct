package com.example.retailgully_packagingapp.data.model.orders_response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrdersResponse implements Serializable, Parcelable
{

    @SerializedName("orderList")
    @Expose
    private List<OrderList> orderList = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Boolean status;
    public final static Parcelable.Creator<OrdersResponse> CREATOR = new Creator<OrdersResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OrdersResponse createFromParcel(Parcel in) {
            return new OrdersResponse(in);
        }

        public OrdersResponse[] newArray(int size) {
            return (new OrdersResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3654003844434551353L;

    protected OrdersResponse(Parcel in) {
        in.readList(this.orderList, (OrderList.class.getClassLoader()));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public OrdersResponse() {
    }

    public List<OrderList> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderList> orderList) {
        this.orderList = orderList;
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
        dest.writeList(orderList);
        dest.writeValue(message);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}
