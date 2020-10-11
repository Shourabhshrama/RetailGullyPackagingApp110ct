package com.example.retailgully_packagingapp.ui.orders

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.artdeza.app.helper.EasyPrefrences
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.model.OrderDetail
import com.example.retailgully_packagingapp.data.model.PurchaseModel
import com.example.retailgully_packagingapp.data.model.SubmitEditQty
import com.example.retailgully_packagingapp.data.model.SubmitEditQtyBase
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_order_detail.view.*
import kotlinx.android.synthetic.main.home_action_bar.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderDetailFragment : Fragment(), OrderDetailAdapter.HandleOnClick {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var adapter = OrderDetailAdapter()
    var adapter2 = OrderDetailAdapter2()
    private lateinit var notificationsViewModel: NotificationsViewModel
    var order_id = 0
    var dataList2 = ArrayList<SubmitEditQty>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_order_detail, container, false)
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        order_id = arguments?.getInt("orderId", 0)!!
        v.header.text = "Akram Khan"
        v.iv_back_store.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        v.recyclerview_purchasedetail.layoutManager = LinearLayoutManager(v.context)

        // callApi(v)
        callApi2(v)
        v.btn_submit_orderr.setOnClickListener {
            var data = ""
            var item = SubmitEditQtyBase(adapter2.getData())
            val gson = Gson()
            data = gson.toJson(item)
            Log.d("data2", data)
            notificationsViewModel.managerupdate(data, requireContext()).observe(viewLifecycleOwner, Observer {
                if(it.success){
                    Toast.makeText(requireContext(),it.message,Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(requireContext(),it.message,Toast.LENGTH_SHORT).show()
                }
            })

        }
        return v
    }

    fun callApi(root: View) {

        notificationsViewModel.getOreder(order_id).observe(viewLifecycleOwner, Observer {

            if (it.status) {
                root.orderdetail_loading.visibility = View.GONE
                root.recyclerview_purchasedetail.adapter = adapter
                adapter.swapData(it.orderDetail.items, this@OrderDetailFragment)
                adapter.notifyDataSetChanged()
            } else {

                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun callApi2(root: View) {

        notificationsViewModel.getOrederManager(order_id).observe(viewLifecycleOwner, Observer {

            if (!it.status) {
                root.orderdetail_loading.visibility = View.GONE
                root.recyclerview_purchasedetail.adapter = adapter2
                it.data?.let { it1 -> adapter2.swapData(it1, this@OrderDetailFragment) }
                adapter2.notifyDataSetChanged()
            } else {

                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun handleItemClick(item: PurchaseModel?) {

    }
}