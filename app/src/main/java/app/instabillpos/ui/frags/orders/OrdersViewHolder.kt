package app.instabillpos.ui.frags.orders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.instabillpos.R
import app.instabillpos.databinding.OrderListBinding
import app.instabillpos.mProguard.Model.getInvoiceListModel

class OrdersViewHolder(
    private val context: Context,
    private val bind: OrderListBinding,
    private val listener: OrderAdapter.ItemListener
) : RecyclerView.ViewHolder(bind.root), View.OnClickListener {

    init {
        bind.card.setOnClickListener(this)
    }

    private lateinit var data: getInvoiceListModel.Datum

    fun bind(item: getInvoiceListModel.Datum) {
        data = item
        bind.name.text = data.customerName?.toString()
        bind.orderID.text = "Order Id : " + data.id
        bind.amount.text = "₹ ${data.balanceDue?.toString()}"

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.card -> {
                listener.onOrderSelected(data)
            }
        }

    }

}