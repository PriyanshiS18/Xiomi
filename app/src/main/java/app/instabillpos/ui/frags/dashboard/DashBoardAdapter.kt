package app.instabillpos.ui.frags.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.instabillpos.databinding.ProductsListBinding
import app.instabillpos.repository.entities.products.Data
import app.instabillpos.utils.mUtil

class DashBoardAdapter(
    private val context: Context,
    private val listener: ItemListener
) :
    RecyclerView.Adapter<DashBoardViewHolder>() {


    interface ItemListener {
        fun addItemToCard(data: Data, editFlag: Boolean)
    }


    private val items = ArrayList<Data>()

    fun setItems(items: ArrayList<Data>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardViewHolder {
        val binding: ProductsListBinding =
            ProductsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DashBoardViewHolder(context, binding, listener)
    }

    override fun onBindViewHolder(holder: DashBoardViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}