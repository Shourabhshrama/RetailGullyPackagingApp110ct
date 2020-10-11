package com.example.retailgully_packagingapp.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.model.ProductResponse
import com.example.retailgully_packagingapp.data.model.Products
import com.example.retailgully_packagingapp.data.model.PurchaseModel
import com.example.retailgully_packagingapp.data.model.UserOrderResponse
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.home_action_bar.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment(), PurchaseListAdapter.HandleOnClick {

    private lateinit var dashboardViewModel: DashboardViewModel
    var adapter = PurchaseListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        root.header.text = "Purchase List"
        root.recyclerview_purchaselist.layoutManager = LinearLayoutManager(root.context)
        root.recyclerview_purchaselist.adapter = adapter



        callApi(root)

        return root
    }


    fun callApi(view: View) {
        dashboardViewModel.getProductList().observe(viewLifecycleOwner, Observer {
            if (it.ack.equals(1)) {
                view.product_loading.visibility = View.GONE
                if (it.data != null && it.data!!.isEmpty()) {
                    Toast.makeText(view.context, it.message, Toast.LENGTH_SHORT).show()
                }
                it.data?.let { it1 -> adapter.swapData(it1, this@DashboardFragment) }
                adapter.notifyDataSetChanged()
            } else {
                view.product_loading.visibility = View.GONE
                Toast.makeText(view.context, it.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun handleItemClick(item: Products?) {
        val itemDetails = Bundle()
//        itemDetails.putInt("itemProductId", item!!.productId)
//        itemDetails.putString("itemProductName", item!!.name)
//        Log.e("data", item!!.productId.toString() + "")

        if (item?.product_type != null) {
            Log.e("product_id", item.product_id)
            Log.e("product_type", item.product_type!!)
            val storeFragment = PurchaseListDetailFragment()
            itemDetails.putString("product_id", item.product_id)
            itemDetails.putString("product_type", item.product_type!!)
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
}