package app.instabillpos.ui.frags.customers

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.instabillpos.R
import app.instabillpos.databinding.CustomerListBinding
import app.instabillpos.mProguard.Model.CustomerListModel

class CustomersViewHolder(
    private val context: Context,
    private val bind: CustomerListBinding,
    private val listener: CustomersAdapter.ItemListener
) : RecyclerView.ViewHolder(bind.root), View.OnClickListener {

    init {
        bind.card.setOnClickListener(this)
    }

    private lateinit var data: CustomerListModel.Datum

    fun bind(item: CustomerListModel.Datum) {
        data = item
        bind.name.text = data.name?.toString()
        bind.mobile.text = data.mobile?.toString()
        /*bind.name.text = data.name
        bind.price.text = "₹ " + data.productRate
        Glide.with(context)
            .load("https://instabill.co/public/product_images/" + data.image)
            .error(R.drawable.sample_image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(bind.image);*/

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.card -> {

            }
        }

    }

}