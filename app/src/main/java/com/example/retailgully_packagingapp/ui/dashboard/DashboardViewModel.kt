package com.example.retailgully_packagingapp.ui.dashboard

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artdeza.app.helper.EasyPrefrences
import com.example.retailgully_packagingapp.data.model.*
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DashboardViewModel : ViewModel() {

    fun assignProductTypeProduct(
        productid: String,
        producttype: String
    ): LiveData<AssignProductReponse> {
        var data = MutableLiveData<AssignProductReponse>()
        RetrofitClientInstance.getRetrofitInstance()
            .create(RetroFitService::class.java)
            .assignProductTypeProduct(productid, producttype)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<AssignProductReponse>() {
                override fun onSuccess(t: AssignProductReponse) {
                    data.value = t
                }

                override fun onError(e: Throwable) {

                    var response = AssignProductReponse(0, null, null, "Something  went Wrong")
                    response.status =1
                    response.message = "Something  went Wrong"
                    data.value = response
                }


            })
        return data


    }

    fun getProductList(

    ): LiveData<ProductResponse> {
        var data = MutableLiveData<ProductResponse>()
        RetrofitClientInstance.getRetrofitInstance()
            .create(RetroFitService::class.java)
            .getProductList( )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<ProductResponse>() {
                override fun onSuccess(t: ProductResponse) {
                    data.value = t
                }

                override fun onError(e: Throwable) {

                    var response = ProductResponse(1,null, "Something Went Wrong")

                    data.value = response
                }


            })
        return data


    }

    fun assignEditQtyToItem(order_item_id:String,data1: String, context: Context): LiveData<AssignResponse> {

        var data = MutableLiveData<AssignResponse>()
        RetrofitClientInstance.getRetrofitInstance().create(RetroFitService::class.java)
            .assignEditQtyToItem(order_item_id, data1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<AssignResponse>() {
                override fun onSuccess(response: AssignResponse) {
                    data.value = response
                }

                override fun onError(e: Throwable) {
                    var response = AssignResponse(0, "Something Went Wrong")

                    data.value = response
                }

            }
            )
        return data
    }
}