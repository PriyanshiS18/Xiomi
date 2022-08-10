package app.instabillpos.ui.frags.customers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.instabillpos.databinding.CustomerListBinding
import app.instabillpos.mProguard.Model.CustomerListModel


class CustomersAdapter(
    private val context: Context,
    private val listener: ItemListener
) :
    RecyclerView.Adapter<CustomersViewHolder>() {


    interface ItemListener {

    }


    private val items = ArrayList<CustomerListModel.Datum>()

    fun setItems(items: ArrayList<CustomerListModel.Datum>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomersViewHolder {
        val binding: CustomerListBinding =
            CustomerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomersViewHolder(context, binding, listener)
    }

    override fun onBindViewHolder(holder: CustomersViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}