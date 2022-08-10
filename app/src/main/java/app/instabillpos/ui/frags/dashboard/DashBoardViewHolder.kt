package app.instabillpos.ui.frags.dashboard

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.instabillpos.R
import app.instabillpos.databinding.ProductsListBinding
import app.instabillpos.repository.entities.products.Data
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class DashBoardViewHolder(
    private val context: Context,
    private val bind: ProductsListBinding,
    private val listener: DashBoardAdapter.ItemListener
) : RecyclerView.ViewHolder(bind.root), View.OnClickListener {

    init {
        bind.card.setOnClickListener(this)
    }

    private lateinit var data: Data

    fun bind(item: Data) {
        data = item
        bind.name.text = data.name
        bind.price.text = "₹ " + data.productRate
        Glide.with(context)
            .load("https://instabill.co/public/product_images/" + data.image)
            .error(R.drawable.sample_image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(bind.image);

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.card -> {
                listener.addItemToCard(data,false)
            }
        }

    }

}