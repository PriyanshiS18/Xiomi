package app.instabillpos.ui.frags.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.instabillpos.databinding.OrderItemListBinding
import app.instabillpos.repository.entities.products.Data
import app.instabillpos.utils.mUtil

class OrderDetailAdapter(
    private val context: Context,
    private val listener: ItemListener
) :
    RecyclerView.Adapter<OrderDetailViewHolder>() {


    interface ItemListener {
        fun subtract(data: Data, position: Int)
        fun add(data: Data, position: Int)

    }

    private val items = ArrayList<Data>()

    fun setItems(items: ArrayList<Data>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderDetailViewHolder {
        val binding: OrderItemListBinding =
            OrderItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderDetailViewHolder(context, binding, listener)
    }

    override fun onBindViewHolder(holder: OrderDetailViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}