package com.example.retailgully_packagingapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.artdeza.app.helper.EasyPrefrences
import com.example.retailgully_packagingapp.MainActivity
import com.example.retailgully_packagingapp.R
import com.mcsandroid.myapplication.helper.PreferenceManager
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var viewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel= ViewModelProviders.of(this).get(AuthViewModel::class.java)
        button_login.setOnClickListener {
            if (valid()) {
                login_loading.visibility = View.VISIBLE
                viewModel.login(et_mobile.text.toString(), et_pass.text.toString()).observe(this, Observer {
                    if (it.token) {
                        login_loading.visibility = View.GONE
                        var prefManage = PreferenceManager(this@LoginActivity)
                        prefManage.setFirstTimeLaunch(false)
                        EasyPrefrences(this@LoginActivity).putInt(
                            "id",
                            it .userData.id
                        )
                        EasyPrefrences(this@LoginActivity).putString(
                            "name",
                            it .userData.name
                        )
                        EasyPrefrences(this@LoginActivity).putString(
                            "email",
                            it .userData.email
                        )
                        EasyPrefrences(this@LoginActivity).putString(
                            "api_token",
                            it .userData.apiToken
                        )
                        EasyPrefrences(this@LoginActivity).putInt(
                            "role_id",
                            it .userData.roleId
                        )
                        EasyPrefrences(this@LoginActivity).putString(
                            "states_id",
                            it .userData.statesId
                        )
                        EasyPrefrences(this@LoginActivity).putString(
                            "cities_id",
                            it .userData.citiesId
                        )
                        EasyPrefrences(this@LoginActivity).putString(
                            "areas_id",
                            it .userData.areasId
                        )
//                        EasyPrefrences(this@LoginActivity).putInt(
//                            "stores_id",
//                            it .userData.storeId
//                        )
                        EasyPrefrences(this@LoginActivity).putString(
                            "store_id",
                            it .userData.storeId
                        )
                        val intent = Intent(this, MainActivity::class.java)
                        //                    intent.putExtra("from","")
                        startActivity(intent)
                        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
                        finish()
                    } else {
                        login_loading.visibility = View.GONE
                        tv_auth_fail.visibility = View.VISIBLE
                        tv_auth_fail.text = it.message
                        Handler().postDelayed(object : Runnable {
                            override fun run() {
                                tv_auth_fail.visibility = View.GONE
                            }

                        }, 2000)

                    }
                })
            }

        }
    }

    private fun valid(): Boolean {
        if (et_mobile.text.toString().isEmpty()) {
            tv_auth_fail.visibility = View.VISIBLE
            tv_auth_fail.text = "Please Enter Email"
            Handler().postDelayed(object : Runnable {
                override fun run() {
                    tv_auth_fail.visibility = View.GONE
                }

            }, 2000)
            return false
        }
        if (et_pass.text.toString().isEmpty()) {
            tv_auth_fail.visibility = View.VISIBLE
            tv_auth_fail.text = "Please Enter Password"
            Handler().postDelayed(object : Runnable {
                override fun run() {
                    tv_auth_fail.visibility = View.GONE
                }

            }, 2000)
            return false
        }
        return true
    }
}