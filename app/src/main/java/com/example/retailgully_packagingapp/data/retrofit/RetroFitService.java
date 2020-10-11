package com.example.retailgully_packagingapp.data.retrofit;

/*
 * Created by Ameer Parappurath on 4/25/2017.
 * LivePages Ltd
 * ameer@elivepages.com
 */




import com.example.retailgully_packagingapp.data.model.AllOrderResponse;
import com.example.retailgully_packagingapp.data.model.AssignProductReponse;
import com.example.retailgully_packagingapp.data.model.AssignResponse;
import com.example.retailgully_packagingapp.data.model.LoginResponse;
import com.example.retailgully_packagingapp.data.model.ProductResponse;
import com.example.retailgully_packagingapp.data.model.UpdateItemStatusResponse;
import com.example.retailgully_packagingapp.data.model.UserOrderResponse;
import com.example.retailgully_packagingapp.data.model.order_response.OrderDetailResponse;
import com.example.retailgully_packagingapp.data.model.order_response.OrderResponse;
import com.example.retailgully_packagingapp.data.model.orders_response.OrdersResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetroFitService {

    @GET("/api/getAllOrders")
    Single<AllOrderResponse> getAllOrders();

    @GET("/api/usersWhoOrder")
    Single<UserOrderResponse> getUser();

    @GET("/api/listOfProduct")
    Single<ProductResponse> getProductList();


    @GET("/api/assignProductTypeProduct/{productid}/{producttype}")
    Single<AssignProductReponse> assignProductTypeProduct(@Path("productid") String productid,
                                                        @Path("producttype") String producttype);
//
    @POST("/api/vendor/login")
    @FormUrlEncoded
    Single<LoginResponse> login(@Field("email") String email,
                                @Field("password") String password);

    @POST("/api/updateItemStatus")
    @FormUrlEncoded
    Single<UpdateItemStatusResponse> updateItemStatus(@Path("itemId") String itemId);


    @POST("/api/updateItemStatusByManager")
    @FormUrlEncoded
    Single<UpdateItemStatusResponse> updateItemStatusByManager(

            @Path("orderId") Integer orderId, @Path("item_json") String item_json );


    @POST("/api/assignEditQtyToItem")
    @FormUrlEncoded
    Single<AssignResponse> assignEditQtyToItem(

            @Field("id") String itemid, @Field("editIds") String editIds );
//


//    @POST("customer/register")
//    @FormUrlEncoded
//    Call<RegisterResponse> register(@Field("first_name") String firstName,
//                                    @Field("last_name") String lastName,
//                                    @Field("email") String email,
//                                    @Field("phone") String phone,
//                                    @Field("password") String password,
//                                    @Field("password_confirmation") String passwordConfirmation,
//                                    @Field("customer_group_id") String customerGroupId,
//                                    @Field("gender") String gender
//    );
//
//    @POST("customer/editProfile")
//    @FormUrlEncoded
//    Call<LoginResponse> editProfile(@Field("id") int id,
//                                    @Field("first_name") String firstName,
//                                    @Field("last_name") String lastName,
//                                    @Field("phone") String phone,
//                                    @Field("password") String password,
//                                    @Field("password_confirmation") String passwordConfirmation,
//                                    @Field("customer_group_id") String customerGroupId,
//                                    @Field("gender") String gender
//    );
//
//    @POST("customer/register")
//    @FormUrlEncoded
//    Call<RegisterResponse> resendOtp(@Field("email") String email,
//                                     @Field("phone") String phone
//    );
//
//    @POST("customer/otpverification")
//    @FormUrlEncoded
//    Call<LoginResponse> otpverification(@Field("id") int id,
//                                        @Field("otp") String otp
//    );
//
//    @GET("rootCategories")
//    Call<CategoryResponse> getRootCategories();
//
//    @GET("stores/{categoryId}")
//    Call<StoreResponse> getStores(@Path("categoryId") int categoryId);
//
//    @GET("productsByStore/{storeId}")
//    Call<ProductResponse> getProductsByStore(@Path("storeId") int storeId);
//
//    @GET("addresses/{userId}")
//    Call<AddressResponse> getAddresses(@Path("userId") int userId);
//
//
//    @POST("addresses/create")
//    @FormUrlEncoded
//    Call<StandardResponse> addAddress(@Field("customer_id") int userId,
//                                      @Field("address1") String address1,
//                                      @Field("address2") String address2,
//                                      @Field("country") String country,
//                                      @Field("state") String state,
//                                      @Field("city") String city,
//                                      @Field("postcode") String postcode,
//                                      @Field("latitude") String latitude,
//                                      @Field("longitude") String longitude,
//                                      @Field("first_name") String firstName,
//                                      @Field("last_name") String lastName,
//                                      @Field("phone") String phone,
//                                      @Field("default_address") int defaultAddress
//    );
//
//    @POST("checkout/custom-order")
//    @FormUrlEncoded
//    Call<CreateOrderResponse> saveOrder(@Field("customer_id") int userId,
//                                        @Field("cart") String cart
//    );
//
    @GET("api/orders/{orderId}")
    Single<OrderResponse> getOrder(@Path("orderId") int orderId);

    @GET("api/orderItemsForManager/{orderId}")
    Single<OrderDetailResponse> orderItemsForManager(@Path("orderId") int orderId);
//
    @GET("api/orders")
    Single<OrdersResponse> getOrders(@Query("store_id") int storeId);
//
//    @GET("orderItems/{storeId}")
//    Call<OrderItemsResponse> getOrderItems(@Path("storeId") int storeId);
//
//    @POST("updateProduct/{product_id}")
//    @FormUrlEncoded
//    Call<StandardResponse> updateProduct(@Path("product_id") int productId,
//                                         @Field("new_price") Double newPrice,
//                                         @Field("old_price") Double oldPrice,
//                                         @Field("store_id") int storeId
//    );
//
//
//
//    @GET("getEditQtyItemsByProductId/{id}")
//    Call<EditItemQtyResponse> getEditQtyItemsByProductId(@Path("id") int productId);
//
//    @GET("getExpensesType")
//    Observable<ExpensesResponse> getExpensesType();
//
//    @POST("UpdateEditQtyItem")
//    @FormUrlEncoded
//    Call<StandardResponse> UpdateEditQtyItem(@Field("id") int id,
//                                             @Field("price") String price,
//                                             @Field("weight") String weight
//    );


}

