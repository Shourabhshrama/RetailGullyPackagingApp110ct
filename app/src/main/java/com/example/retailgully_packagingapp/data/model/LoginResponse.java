package com.example.retailgully_packagingapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable, Parcelable {

    @SerializedName("token")
    @Expose
    private Boolean token;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userData")
    @Expose
    private UserData userData;
    public final static Parcelable.Creator<LoginResponse> CREATOR = new Creator<LoginResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginResponse createFromParcel(Parcel in) {
            return new LoginResponse(in);
        }

        public LoginResponse[] newArray(int size) {
            return (new LoginResponse[size]);
        }

    };
    private final static long serialVersionUID = 5375894392739754035L;

    protected LoginResponse(Parcel in) {
        this.token = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.userData = ((UserData) in.readValue((UserData.class.getClassLoader())));
    }

    public LoginResponse() {
    }

    public Boolean getToken() {
        return token;
    }

    public void setToken(Boolean token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(token);
        dest.writeValue(message);
        dest.writeValue(userData);
    }

    public int describeContents() {
        return 0;
    }
}
