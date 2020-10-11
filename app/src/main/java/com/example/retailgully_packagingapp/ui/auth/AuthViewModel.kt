package com.example.retailgully_packagingapp.ui.auth

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retailgully_packagingapp.data.model.LoginResponse
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class AuthViewModel : ViewModel(){
    fun login(email: String, password: String): LiveData<LoginResponse> {
        var data = MutableLiveData<LoginResponse>()
        RetrofitClientInstance.getRetrofitInstance()
            .create(RetroFitService::class.java)
            .login(email, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<LoginResponse>() {
                override fun onSuccess(t: LoginResponse) {
                    data.value = t
                }

                override fun onError(e: Throwable) {

                    var response = LoginResponse()
                    response.token = false
                    response.message = "Something  went Wrong"
                    data.value = response
                }


            })
        return data


    }

}