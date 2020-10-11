package com.example.retailgully_packagingapp.ui.dashboard

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdeveloper.library.MultiSelectDialog
import com.abdeveloper.library.MultiSelectDialog.SubmitCallbackListener
import com.abdeveloper.library.MultiSelectModel
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.model.Customer
import com.example.retailgully_packagingapp.data.model.PurchaseProducts
import kotlinx.android.synthetic.main.fragment_purchase_list_detail.view.*
import kotlinx.android.synthetic.main.home_action_bar.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PurchaseListDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PurchaseListDetailFragment : Fragment(), PurchaseDetailAdapter.HandleOnClick {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewModel: DashboardViewModel
    var adapter = PurchaseDetailAdapter()
    var purchaseProductList = ArrayList<PurchaseProducts>()
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
        var v = inflater.inflate(R.layout.fragment_purchase_list_detail, container, false)
        v.header.setText("Allu Katta")

        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        var product_id = arguments?.getString("product_id")
        var product_type = arguments?.getString("product_type")
        v.recyclerview_purchasedetail.layoutManager = LinearLayoutManager(v.context)
        v.recyclerview_purchasedetail.adapter = adapter

        if (product_id != null) {
            if (product_type != null) {
                callApi(v, product_id, product_type)
            }
        }


        return v
    }

    fun callApi(v: View, product_id: String, product_type: String) {
        viewModel.assignProductTypeProduct(product_id, product_type)
            .observe(viewLifecycleOwner, Observer {

                if (it.status == 0) {

                    var total = it.customers
                    it.purchase_product_list?.let { it1 -> purchaseProductList.addAll(it1) }
                    v.purchaselist_loading.visibility = View.GONE
                    if (total != null) {
                        adapter.swapData(total, this@PurchaseListDetailFragment)
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    v.purchaselist_loading.visibility = View.GONE
                    Toast.makeText(v.context, it.message, Toast.LENGTH_SHORT).show()
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
         * @return A new instance of fragment PurchaseListDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PurchaseListDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun handleSelectItemClick(item: Customer) {
        makeMultiSelectDialog(item)
    }


    private fun makeMultiSelectDialog(item: Customer) {
        val listOfCountries =
            ArrayList<MultiSelectModel>()
        for (field in purchaseProductList) {
            listOfCountries.add(
                MultiSelectModel(
                    field.product_qty_price_id.toInt(), field.qty
                )
            )
        }
        var multiSelectDialog = MultiSelectDialog()
            .title("Select Product Qty") //setting title for dialog
            .titleSize(25f)
            .positiveText("Done")
            .negativeText("Cancel")
            .setMaxSelectionLimit(item.qty.toInt())
            .setMinSelectionLimit(item.qty.toInt()) //you can set minimum checkbox selection limit (Optional)
            .multiSelectList(listOfCountries) // the multi select model list with ids and name
            .onSubmit(object : SubmitCallbackListener {
                override fun onSelected(
                    selectedIds: ArrayList<Int>,
                    selectedNames: ArrayList<String>,
                    dataString: String
                ) {
                    var itemIds = ""
                    for (ids in selectedIds) {
                        itemIds += "$ids,"
                    }
                    Log.e("mamnoon", itemIds)
                    itemIds.replaceAfterLast(",", "")
                    //callApiForAssignEditQtyToItem(itemIds)
                    viewModel.assignEditQtyToItem(item.order_item_id, itemIds, requireContext())
                        .observe(this@PurchaseListDetailFragment, Observer {
                            if (it.code.equals(0)) {

                                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT)
                                    .show()
                                val ft: FragmentTransaction =
                                    childFragmentManager.beginTransaction()
                                if (Build.VERSION.SDK_INT >= 26) {
                                    ft.setReorderingAllowed(false)
                                }
                                ft.detach(this@PurchaseListDetailFragment)
                                    .attach(this@PurchaseListDetailFragment).commit()
                            } else {
                                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT)
                                    .show()

                            }
                        })


                }

                override fun onCancel() {
                    Log.d("in Builder", "Dialog cancelled")
                }
            })
        fragmentManager?.let { multiSelectDialog.show(it, "") }

    }

}