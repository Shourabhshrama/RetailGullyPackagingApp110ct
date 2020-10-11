package com.example.retailgully_packagingapp.ui.home

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.model.AllOrderResponse
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.home_action_bar.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        root.header.text = "Home"
        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })


        textView.setOnClickListener {
            val storeFragment = InVoiceListFragment()
            //  storeFragment.setArguments(itemDetails)
            fragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_open_exit)
                ?.replace(
                    R.id.nav_host_fragment,
                    storeFragment

                )
                ?.addToBackStack(null)
                ?.commit()
        }

        homeViewModel.getHomeData().observe(this, Observer {
            if (it.ack.equals(1)) {
                root.home_loading.visibility=View.GONE
                startCountAnimation(root.text_home, it.totalOrder)
            } else {
                root.home_loading.visibility=View.GONE


            }
        })
//        var orders = RetrofitClientInstance.getRetrofitInstance()
//            .create(RetroFitService::class.java).allOrders
//
//        orders.enqueue(object : Callback<AllOrderResponse> {
//            override fun onFailure(call: Call<AllOrderResponse>, t: Throwable) {
//                Log.e("error", t.toString())
//            }
//
//            override fun onResponse(
//                call: Call<AllOrderResponse>,
//                response: Response<AllOrderResponse>
//            ) {
//                if (response.isSuccessful) {
//                    var total = response.body()?.totalOrder
//                    if (total != null) {
//                        startCountAnimation(root.text_home, total)
//                    } else {
//                    }
//                }
//            }
//
//        })

        return root
    }

    private fun startCountAnimation(view: TextView, count: Int) {
        val animator = ValueAnimator.ofInt(0, count)
        animator.duration = 1000
        animator.addUpdateListener { animation -> view.setText(animation.animatedValue.toString()) }
        animator.start()
    }
}