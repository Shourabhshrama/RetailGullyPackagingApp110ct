package com.example.retailgully_packagingapp.ui.orders

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artdeza.app.helper.EasyPrefrences
import com.example.retailgully_packagingapp.data.model.AllOrderResponse
import com.example.retailgully_packagingapp.data.model.UpdateItemStatusResponse
import com.example.retailgully_packagingapp.data.model.order_response.OrderDetailResponse
import com.example.retailgully_packagingapp.data.model.order_response.OrderResponse
import com.example.retailgully_packagingapp.data.model.orders_response.OrdersResponse
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationsViewModel : ViewModel() {


    fun managerupdate(data1: String, context: Context): LiveData<UpdateItemStatusResponse> {

        var data = MutableLiveData<UpdateItemStatusResponse>()
        RetrofitClientInstance.getRetrofitInstance().create(RetroFitService::class.java)
            .updateItemStatusByManager(EasyPrefrences(context).getInt("id"), data1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<UpdateItemStatusResponse>() {
                override fun onSuccess(response: UpdateItemStatusResponse) {
                    data.value = response
                }

                override fun onError(e: Throwable) {
                    var response = UpdateItemStatusResponse(false, "Something Went Wrong")

                    data.value = response
                }

            }
            )
        return data
    }


    fun getOreders(storeId: Int): LiveData<OrdersResponse> {
        var data = MutableLiveData<OrdersResponse>()
        val mService: RetroFitService = RetrofitClientInstance.getRetrofitInstance().create(
            RetroFitService::class.java
        )
        mService.getOrders(storeId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<OrdersResponse>() {
                override fun onSuccess(response: OrdersResponse) {
                    data.value = response
                }

                override fun onError(e: Throwable) {
                    var response = OrdersResponse()
                    response.status = false
                    response.message = "Something Went Wrong"
                    data.value = response
                }

            }
            )
        return data
    }

    fun getOreder(orderId: Int): LiveData<OrderResponse> {
        var data = MutableLiveData<OrderResponse>()
        val mService: RetroFitService = RetrofitClientInstance.getRetrofitInstance().create(
            RetroFitService::class.java
        )
        mService.getOrder(orderId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<OrderResponse>() {
                override fun onSuccess(response: OrderResponse) {
                    data.value = response
                }

                override fun onError(e: Throwable) {
                    var response = OrderResponse()
                    response.status = false
                    response.message = "Something Went Wrong"
                    data.value = response
                }

            }
            )
        return data
    }

    fun getOrederManager(orderId: Int): LiveData<OrderDetailResponse> {
        var data = MutableLiveData<OrderDetailResponse>()
        val mService: RetroFitService = RetrofitClientInstance.getRetrofitInstance().create(
            RetroFitService::class.java
        )
        mService.orderItemsForManager(orderId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<OrderDetailResponse>() {
                override fun onSuccess(response: OrderDetailResponse) {
                    data.value = response
                }

                override fun onError(e: Throwable) {
                    var response = OrderDetailResponse(false, null, "Something Went Wrong")

                    data.value = response
                }

            }
            )
        return data
    }
}