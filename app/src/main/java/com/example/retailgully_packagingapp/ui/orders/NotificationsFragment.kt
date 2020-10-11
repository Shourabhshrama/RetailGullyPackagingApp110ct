package com.example.retailgully_packagingapp.ui.orders

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.solver.GoalRow
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.artdeza.app.helper.EasyPrefrences
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.model.Order
import com.example.retailgully_packagingapp.data.model.orders_response.OrderList
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance

import kotlinx.android.synthetic.main.fragment_notifications.view.*
import kotlinx.android.synthetic.main.home_action_bar.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationsFragment : Fragment(), OrderListAdapter.HandleOnClick {
    lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var notification_loading: LottieAnimationView
    var orderListAdapter = OrderListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        root.header.text = "Order"
        val textView: TextView = root.findViewById(R.id.text_notifications)
        swipeRefresh = root.swipelayout_order

        root.recyclerview_order.layoutManager = LinearLayoutManager(root.context)
        root.recyclerview_order.adapter = orderListAdapter
        notification_loading = root.notification_loading

        callApi()

        swipeRefresh.setOnRefreshListener {

            callApi()

        }
        return root
    }


    private fun callApi() {
        swipeRefresh.setRefreshing(false)
        notificationsViewModel.getOreders(
            EasyPrefrences(requireContext()).getString("store_id").toInt()
        )
            .observe(viewLifecycleOwner, Observer {

                if (it.status) {
                    notification_loading.visibility = View.GONE
                    orderListAdapter.swapData(it.orderList, this)
                } else {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            })

    }

    override fun handleItemClick(item: OrderList?) {
        val itemDetails = Bundle()
        itemDetails.putInt("orderId", item!!.id)

      //  Log.e("data", item!!.productId.toString() + "")
        val storeFragment = OrderDetailFragment()
        storeFragment.setArguments(itemDetails)
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
}