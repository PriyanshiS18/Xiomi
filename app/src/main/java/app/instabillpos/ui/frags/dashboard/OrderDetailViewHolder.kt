package app.instabillpos.ui.frags.dashboard

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.instabillpos.R
import app.instabillpos.databinding.OrderItemListBinding
import app.instabillpos.repository.entities.products.Data
import app.instabillpos.utils.mUtil.formatDoubleToTwoDecimals

class OrderDetailViewHolder(
    private val context: Context,
    private val bind: OrderItemListBinding,
    private val listener: OrderDetailAdapter.ItemListener
) : RecyclerView.ViewHolder(bind.root), View.OnClickListener {

    init {
        bind.card.setOnClickListener(this)
        bind.add.setOnClickListener(this)
        bind.subtract.setOnClickListener(this)
    }

    private lateinit var data: Data

    fun bind(item: Data) {
        data = item
        bind.name.text = data.name
        bind.rate.text = "₹ " + data.productRate
        bind.quantity.text = data.productType

        if (data.discount_amount.isNullOrEmpty()) {
            data.discount_amount = "0"
        }
        if (data.discount_status.isNullOrEmpty()) {
            data.discount_status = ""
        }

        data.purchaseDescription = " "

        bind.amount.text =
            "₹ ${formatDoubleToTwoDecimals(data.productType!!.toDouble() * data.productRate!!.toDouble())}"

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.card -> {

            }
            R.id.subtract -> {
                listener.subtract(data, position)
            }
            R.id.add -> {
                listener.add(data, position)
            }
        }

    }

}