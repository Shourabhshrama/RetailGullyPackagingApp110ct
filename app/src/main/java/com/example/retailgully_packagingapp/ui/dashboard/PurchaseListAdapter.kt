package com.example.retailgully_packagingapp.ui.dashboard


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.model.Products
import com.example.retailgully_packagingapp.data.model.PurchaseModel
import kotlinx.android.synthetic.main.row_purchase.view.*
import java.util.*
import kotlin.collections.ArrayList

class PurchaseListAdapter : RecyclerView.Adapter<PurchaseListAdapter.PurchaseLIstViewHolder>() {

    private var data: ArrayList<Products> = ArrayList()
    lateinit var dashboardFragment: DashboardFragment
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseLIstViewHolder {
        return PurchaseLIstViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_purchase, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PurchaseLIstViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(
        data: ArrayList<Products>,
        dashboardFragment: DashboardFragment
    ) {
        this.data = data
        this.dashboardFragment = dashboardFragment
        notifyDataSetChanged()
    }

    inner class PurchaseLIstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Products) = with(itemView) {
            row_home_product.text = item.product_name
            purchase_item_qty.text = item.total_qty
            setOnClickListener {
                dashboardFragment.handleItemClick(item)
            }
        }
    }

    interface HandleOnClick {
        fun handleItemClick(item: Products?)
    }
}
