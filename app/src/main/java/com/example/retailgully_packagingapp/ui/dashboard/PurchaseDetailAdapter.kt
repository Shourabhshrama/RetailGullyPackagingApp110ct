package com.example.retailgully_packagingapp.ui.dashboard


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.model.Customer
import kotlinx.android.synthetic.main.row_purchase_detail.view.*
import java.util.*

class PurchaseDetailAdapter :
    RecyclerView.Adapter<PurchaseDetailAdapter.PurchaseDetailViewHolder>() {

    private var data: List<Customer> = ArrayList()
     lateinit var purchaseListDetailFragment: PurchaseListDetailFragment
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseDetailViewHolder {
        return PurchaseDetailViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_purchase_detail, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PurchaseDetailViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(
        data: List<Customer>,
        purchaseListDetailFragment: PurchaseListDetailFragment
    ) {
        this.data = data
        this.purchaseListDetailFragment=purchaseListDetailFragment
        notifyDataSetChanged()
    }

   inner class PurchaseDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Customer) = with(itemView) {
            tv_purcahse_user_name.text = item.name
            tv_purcahse_user_qty.text = item.qty

            tv_purcahse_user_name.setOnClickListener { purchaseListDetailFragment.handleSelectItemClick(
                item
            )
            }
            setOnClickListener {
                purchaseListDetailFragment.handleSelectItemClick(item)

            }
        }
    }
    interface HandleOnClick {

        fun handleSelectItemClick(item: Customer)

    }



}
