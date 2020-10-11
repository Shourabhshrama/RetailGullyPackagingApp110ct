package com.example.retailgully_packagingapp.data.model.orders_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
