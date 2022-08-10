package app.instabillpos.ui.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import app.instabillpos.R
import app.instabillpos.databinding.OrderCreatedBinding
import app.instabillpos.mProguard.Model.CreateOrderr


class OrderCreated(
    private val msg: String,
    private val listener: CreateOrderListner,
    private val createOrder: CreateOrderr
) :
    DialogFragment(),
    View.OnClickListener {

    private var _binding: OrderCreatedBinding? = null
    private val bind get() = _binding!!

    interface CreateOrderListner {
        fun newOrder()
        fun editOrder(createOrder: CreateOrderr)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OrderCreatedBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
    }

    private fun initAllComponents() {
        bind.msg.text = msg
        bind.newOrder.setOnClickListener(this)
        bind.editOrder.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.newOrder -> {
                listener.newOrder()
                dismiss()
            }
            R.id.editOrder -> {
                listener.editOrder(createOrder)
                dismiss()
            }
        }
    }
}