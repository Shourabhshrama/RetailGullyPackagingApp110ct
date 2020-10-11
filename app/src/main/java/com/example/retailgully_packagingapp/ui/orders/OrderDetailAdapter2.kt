package com.example.retailgully_packagingapp.ui.orders


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.model.PurchaseModel
import com.example.retailgully_packagingapp.data.model.SubmitEditQty
import com.example.retailgully_packagingapp.data.model.SubmitEditQtyBase
import com.example.retailgully_packagingapp.data.model.UpdateItemStatusResponse
import com.example.retailgully_packagingapp.data.model.order_response.OrderItem
import com.example.retailgully_packagingapp.data.retrofit.RetroFitService
import com.example.retailgully_packagingapp.data.retrofit.RetrofitClientInstance
import com.example.retailgully_packagingapp.helper.MultiSpinner
import com.example.retailgully_packagingapp.helper.MultiSpinner.MultiSpinnerListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.row_order_detail.view.*

class OrderDetailAdapter2 : RecyclerView.Adapter<OrderDetailAdapter2.OrderDetailViewHolder>() {

    private var data: ArrayList<OrderItem> = ArrayList()
    private var data2: ArrayList<SubmitEditQty> = ArrayList()
    lateinit var orderDetailFragment: OrderDetailFragment
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderDetailViewHolder {
        return OrderDetailViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_order_detail, parent, false)
        )
    }

    override fun getItemCount() = data.size
    fun getData(): ArrayList<SubmitEditQty> {
        return data2
    }

    override fun onBindViewHolder(holder: OrderDetailViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(
        data: ArrayList<OrderItem>,
        orderDetailFragment: OrderDetailFragment
    ) {
        this.data = data
        this.orderDetailFragment = orderDetailFragment
        notifyDataSetChanged()
    }

    inner class OrderDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: OrderItem) = with(itemView) {
            row_home_product.text = item.name
            row_order_product_qty.text = "Qty - " + item.qty_ordered + ""
            var list = ArrayList<String>()
            for (assitem in item.assignItemList) {
                list.add(assitem.qty)
            }


            if (item.product_type.equals("Katta") or item.product_type.equals("Poly Bag") or item.product_type.equals(
                    "Carat"
                )
            ) {
                _home_view_btn.visibility = View.VISIBLE
                _home_view_btn2.visibility = View.GONE
            } else {
                _home_view_btn.visibility = View.GONE
                _home_view_btn2.visibility = View.VISIBLE
            }

            if (item.assignItemList.isNotEmpty()
            ) {
                _home_view_btn.visibility = View.VISIBLE
                _home_view_btn2.visibility = View.GONE
            } else {
                _home_view_btn.visibility = View.GONE
                _home_view_btn2.visibility = View.VISIBLE
            }

            _home_view_btn.setItems(list, "", MultiSpinner.MultiSpinnerListener {
                for (value in it) {
                    if (value) {
                        var oItem = SubmitEditQty(item.id.toInt(), 2)
                        data2.add(oItem)
                    }
                }
            })




            _home_view_btn2.setOnClickListener {
                loading_update_status.visibility = View.VISIBLE

                RetrofitClientInstance.getRetrofitInstance().create(RetroFitService::class.java)
                    .updateItemStatus(item.id.toString()).observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(object : DisposableSingleObserver<UpdateItemStatusResponse>() {
                        override fun onSuccess(t: UpdateItemStatusResponse) {
                            if (t.success) {
                                loading_update_status.visibility = View.GONE
                                Toast.makeText(itemView.context, t.message, Toast.LENGTH_SHORT)
                                    .show()
                            } else {
                                loading_update_status.visibility = View.GONE
                                Toast.makeText(itemView.context, t.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }

                        override fun onError(e: Throwable) {
                            loading_update_status.visibility = View.GONE
                            Toast.makeText(
                                itemView.context,
                                "Something Went Wrong",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    })
            }

            setOnClickListener {

            }
        }
    }

    private val onSelectedListener = MultiSpinnerListener {
        // Do something here with the selected items
    }

    interface HandleOnClick {
        fun handleItemClick(item: PurchaseModel?)
    }
}
