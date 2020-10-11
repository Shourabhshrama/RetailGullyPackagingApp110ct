package com.example.retailgully_packagingapp.ui.home


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.data.InVoice
import com.example.retailgully_packagingapp.data.model.UserOrder
import kotlinx.android.synthetic.main.row_invoice.view.*
import java.util.*
import kotlin.collections.ArrayList

class InVoiceListAdapter : RecyclerView.Adapter<InVoiceListAdapter.InVoiceViewHolder>() {

    private var data: ArrayList<UserOrder> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InVoiceViewHolder {
        return InVoiceViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_invoice, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: InVoiceViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(data: ArrayList<UserOrder>) {
        this.data = data
        notifyDataSetChanged()
    }

    class InVoiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: UserOrder) = with(itemView) {
            textView3.text = item.customer_name
            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}
