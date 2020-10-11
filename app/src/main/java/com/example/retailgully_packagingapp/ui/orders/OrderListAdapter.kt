package com.example.retailgully_packagingapp.ui.orders


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.model.Order
import com.example.retailgully_packagingapp.data.model.PurchaseModel
import com.example.retailgully_packagingapp.data.model.orders_response.OrderList
import kotlinx.android.synthetic.main.row_order.view.*
import java.util.*

class OrderListAdapter : RecyclerView.Adapter<OrderListAdapter.OrderViewHolder>() {

    private var data: List<OrderList> = ArrayList()
    lateinit var notificationsFragment: NotificationsFragment
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_order, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(
        data: List<OrderList>,
        notificationsFragment: NotificationsFragment
    ) {
        this.data = data
        this.notificationsFragment = notificationsFragment
        notifyDataSetChanged()
    }

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: OrderList) = with(itemView) {
            tv_order_user.text = item.customerFirstName + " " + item.customerLastName
            tv_order_user_items.text = item.orderItems

            setOnClickListener {
                notificationsFragment.handleItemClick(item)
            }
        }
    }

    interface HandleOnClick {
        fun handleItemClick(item: OrderList?)
    }
}
