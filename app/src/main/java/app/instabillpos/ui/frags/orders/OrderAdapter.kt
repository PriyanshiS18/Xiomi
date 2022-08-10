package app.instabillpos.ui.frags.orders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.instabillpos.databinding.OrderListBinding
import app.instabillpos.mProguard.Model.getInvoiceListModel


class OrderAdapter(
    private val context: Context,
    private val listener: ItemListener
) :
    RecyclerView.Adapter<OrdersViewHolder>() {


    interface ItemListener {
        fun onOrderSelected(data: getInvoiceListModel.Datum)
    }


    private val items = ArrayList<getInvoiceListModel.Datum>()

    fun setItems(items: ArrayList<getInvoiceListModel.Datum>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val binding: OrderListBinding =
            OrderListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrdersViewHolder(context, binding, listener)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}