package com.example.retailgully_packagingapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserData implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("states_id")
    @Expose
    private String statesId;
    @SerializedName("cities_id")
    @Expose
    private String citiesId;
    @SerializedName("areas_id")
    @Expose
    private String areasId;
    @SerializedName("stores_id")
    @Expose
    private String storesId;
    @SerializedName("store_id")
    @Expose
    private String storeId;
    @SerializedName("remember_token")
    @Expose
    private Object rememberToken;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    public final static Parcelable.Creator<UserData> CREATOR = new Creator<UserData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        public UserData[] newArray(int size) {
            return (new UserData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2822515505048828918L;

    protected UserData(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.apiToken = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.roleId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statesId = ((String) in.readValue((String.class.getClassLoader())));
        this.citiesId = ((String) in.readValue((String.class.getClassLoader())));
        this.areasId = ((String) in.readValue((String.class.getClassLoader())));
        this.storesId = ((String) in.readValue((String.class.getClassLoader())));
        this.storeId = ((String) in.readValue((Integer.class.getClassLoader())));
        this.rememberToken = ((Object) in.readValue((Object.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getStatesId() {
        return statesId;
    }

    public void setStatesId(String statesId) {
        this.statesId = statesId;
    }

    public String getCitiesId() {
        return citiesId;
    }

    public void setCitiesId(String citiesId) {
        this.citiesId = citiesId;
    }

    public String getAreasId() {
        return areasId;
    }

    public void setAreasId(String areasId) {
        this.areasId = areasId;
    }

    public String getStoresId() {
        return storesId;
    }

    public void setStoresId(String storesId) {
        this.storesId = storesId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Object getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(Object rememberToken) {
        this.rememberToken = rememberToken;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(email);
        dest.writeValue(password);
        dest.writeValue(apiToken);
        dest.writeValue(status);
        dest.writeValue(roleId);
        dest.writeValue(statesId);
        dest.writeValue(citiesId);
        dest.writeValue(areasId);
        dest.writeValue(storesId);
        dest.writeValue(storeId);
        dest.writeValue(rememberToken);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
    }

    public int describeContents() {
        return 0;
    }

}