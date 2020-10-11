package com.example.retailgully_packagingapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retailgully_packagingapp.data.model.AllOrderResponse
import com.example.retailgully_packagingapp.data.model.LoginResponse
import com.example.retailgully_packagingapp.data.model.UserOrderResponse
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {

    fun getHomeData(): LiveData<AllOrderResponse> {
        var data = MutableLiveData<AllOrderResponse>()
        RetrofitClientInstance.getRetrofitInstance()
            .create(RetroFitService::class.java)
            .allOrders
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<AllOrderResponse>() {
                override fun onSuccess(t: AllOrderResponse) {
                    data.value = t
                }

                override fun onError(e: Throwable) {

                    var response = AllOrderResponse(0,0,"Something  went Wrong")

                    data.value = response
                }


            })
        return data
    }

    fun getUser(): LiveData<UserOrderResponse> {
        var data = MutableLiveData<UserOrderResponse>()
        RetrofitClientInstance.getRetrofitInstance()
            .create(RetroFitService::class.java)
            .user
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<UserOrderResponse>() {
                override fun onSuccess(t: UserOrderResponse) {
                    data.value = t
                }

                override fun onError(e: Throwable) {

                    var response = UserOrderResponse(0,null,"Something  went Wrong")

                    data.value = response
                }


            })
        return data
    }
}