package com.example.retailgully_packagingapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.InVoice
import com.example.retailgully_packagingapp.data.model.AllOrderResponse
import com.example.retailgully_packagingapp.data.model.UserOrderResponse
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_in_voice_list.view.*
import kotlinx.android.synthetic.main.home_action_bar.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InVoiceListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InVoiceListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var adapter = InVoiceListAdapter()
    lateinit var homeViewModel: HomeViewModel
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
        var v = inflater.inflate(R.layout.fragment_in_voice_list, container, false)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        v.header.text = "Home"
        v.iv_back_store.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        v.recyckerview_invoice.layoutManager = LinearLayoutManager(v.context)
        v.imageView_print.setOnClickListener {
            val storeFragment =
                PrintFragment.newInstance("http://retailgully.com/api/getInvoice", "")
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
        v.recyckerview_invoice.adapter = adapter


        homeViewModel.getUser().observe(this, Observer {
            if (it.ack.equals(1)) {

                it.data?.let { it1 -> adapter.swapData(it1) }
                adapter.notifyDataSetChanged()

            } else {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            }
        })




        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InVoiceListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InVoiceListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}