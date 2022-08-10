package app.instabillpos.ui.frags.modeofpayment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import app.instabillpos.R
import app.instabillpos.databinding.ModeOfPaymentBinding
import app.instabillpos.mProguard.Model.CreateOrderr
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import app.instabillpos.ui.bottomsheets.OrderCreated
import app.instabillpos.utils.mUtil
import app.instabillpos.utils.mUtil.getFinalDateValidUptoSend
import app.instabillpos.utils.mUtil.isValidText
import app.instabillpos.utils.mUtil.mLog
import app.instabillpos.utils.mUtil.todayDate
import com.google.gson.Gson
import com.google.gson.JsonParser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class ModeOfPayment : Fragment(), View.OnClickListener, OrderCreated.CreateOrderListner {

    var preferences: AppSharedPreferences? = null
    private var _binding: ModeOfPaymentBinding? = null
    private val bind get() = _binding!!
    val args: ModeOfPaymentArgs by navArgs()
    val TAG = "SANJAY"
    private val viewModel: ModeOfPaymentViewModel by viewModels()
    var finalInvoiceNumber = ""
    var modeOfPayment = "CASH"
    var timeStamp = ""
    val createOrder = CreateOrderr()
    var data = CreateOrderr()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ModeOfPaymentBinding.inflate(inflater, container, false)
        return bind.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
        amountTextWatcher()
        hideKeyboradOnFocusChanges()

        getInvoiceNumber()
        setUpEditData()

    }

    private fun setUpEditData() {
        if (args.editData.isNotEmpty()) {
            if (args.editData.trim().isNotEmpty()) {
                data =
                    Gson().fromJson(JsonParser().parse(args.editData), CreateOrderr::class.java)
                mLog("Mode of payment :: " + data.modePayment)
                when (data.modePayment) {
                    "CASH" -> {
                        bind.cash.performClick()
                    }
                    "CARD" -> {
                        bind.card.performClick()
                    }
                    "CREDIT" -> {
                        bind.credit.performClick()
                    }
                    "UPI" -> {
                        bind.upi.performClick()
                    }
                }
                bind.amountRecieved.setText(data.amountReceived)
            }

        }
    }

    private fun getInvoiceNumber() {
        CoroutineScope(Dispatchers.Main).launch {
            val invoiceNumber = viewModel.getInvoiceNumber()
            if (invoiceNumber.data?.errorCode.equals("0")) {
                finalInvoiceNumber = "INSTA" + invoiceNumber.data?.data
            }

        }
    }

    private fun amountTextWatcher() {
        bind.amountRecieved.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i(TAG, "beforeTextChanged: " + p0.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i(TAG, "onTextChanged: " + p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
                if (!p0.isNullOrEmpty()) {
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.FLOOR

                    bind.change.setText(
                        df.format(
                            (p0.toString().toFloat() - args.total.toFloat()).toDouble()
                        )
                    )
                    Log.i(TAG, "afterTextChanged: " + p0.toString())
                }
            }
        })
    }

    private fun hideKeyboradOnFocusChanges() {
        bind.dueAmount.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                mUtil.hideKeyboard(requireContext(), v)
            }
        }
        bind.amountRecieved.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                mUtil.hideKeyboard(requireContext(), v)
            }
        }
        bind.change.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                mUtil.hideKeyboard(requireContext(), v)
            }
        }
    }

    private fun initAllComponents() {
        preferences = AppSharedPreferences.getInstance(requireContext())
        bind.back.setOnClickListener(this)
        bind.card.setOnClickListener(this)
        bind.upi.setOnClickListener(this)
        bind.cash.setOnClickListener(this)
        bind.credit.setOnClickListener(this)
        bind.orderNow.setOnClickListener(this)
        bind.order.setOnClickListener(this)
        bind.dueAmount.setText(args.total)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.back -> {
                v.findNavController().popBackStack()
            }
            R.id.order -> {
                bind.orderNow.performClick()
            }
            R.id.orderNow -> {
                if (isValidText(bind.amountRecieved.text.toString().trim(), bind.amountRecieved) &&
                    isValidText(bind.change.text.toString().trim(), bind.change)
                ) {
                    createOrder()
                }
            }
            R.id.upi -> {
                modeOfPayment = "UPI"
                bind.upi.background = resources.getDrawable(R.drawable.rounded_back)
                bind.upi.setTextColor(resources.getColor(R.color.white))
                bind.card.background = resources.getDrawable(R.color.white)
                bind.card.setTextColor(resources.getColor(R.color.black))
                bind.credit.background = resources.getDrawable(R.color.white)
                bind.credit.setTextColor(resources.getColor(R.color.black))
                bind.cash.background = resources.getDrawable(R.color.white)
                bind.cash.setTextColor(resources.getColor(R.color.black))

                bind.credit.setPadding(25, 25, 25, 25)
                bind.card.setPadding(25, 25, 25, 25)
                bind.cash.setPadding(25, 25, 25, 25)
                bind.upi.setPadding(25, 25, 25, 25)


                enableAmountRecieved()
            }
            R.id.cash -> {
                modeOfPayment = "CASH"
                bind.cash.background = resources.getDrawable(R.drawable.rounded_back)
                bind.cash.setTextColor(resources.getColor(R.color.white))
                bind.card.background = resources.getDrawable(R.color.white)
                bind.card.setTextColor(resources.getColor(R.color.black))
                bind.credit.background = resources.getDrawable(R.color.white)
                bind.credit.setTextColor(resources.getColor(R.color.black))
                bind.upi.background = resources.getDrawable(R.color.white)
                bind.upi.setTextColor(resources.getColor(R.color.black))

                bind.credit.setPadding(25, 25, 25, 25)
                bind.card.setPadding(25, 25, 25, 25)
                bind.cash.setPadding(25, 25, 25, 25)
                bind.upi.setPadding(25, 25, 25, 25)


                enableAmountRecieved()
            }
            R.id.card -> {
                modeOfPayment = "CARD"
                bind.card.background = resources.getDrawable(R.drawable.rounded_back)
                bind.card.setTextColor(resources.getColor(R.color.white))
                bind.cash.background = resources.getDrawable(R.color.white)
                bind.cash.setTextColor(resources.getColor(R.color.black))
                bind.credit.background = resources.getDrawable(R.color.white)
                bind.credit.setTextColor(resources.getColor(R.color.black))
                bind.upi.background = resources.getDrawable(R.color.white)
                bind.upi.setTextColor(resources.getColor(R.color.black))

                bind.credit.setPadding(25, 25, 25, 25)
                bind.card.setPadding(25, 25, 25, 25)
                bind.cash.setPadding(25, 25, 25, 25)
                bind.upi.setPadding(25, 25, 25, 25)


                enableAmountRecieved()
            }
            R.id.credit -> {
                modeOfPayment = "CREDIT"
                bind.credit.background = resources.getDrawable(R.drawable.rounded_back)
                bind.credit.setTextColor(resources.getColor(R.color.white))
                bind.card.background = resources.getDrawable(R.color.white)
                bind.card.setTextColor(resources.getColor(R.color.black))
                bind.cash.background = resources.getDrawable(R.color.white)
                bind.cash.setTextColor(resources.getColor(R.color.black))
                bind.upi.background = resources.getDrawable(R.color.white)
                bind.upi.setTextColor(resources.getColor(R.color.black))

                bind.credit.setPadding(25, 25, 25, 25)
                bind.card.setPadding(25, 25, 25, 25)
                bind.cash.setPadding(25, 25, 25, 25)
                bind.upi.setPadding(25, 25, 25, 25)

                bind.amountRecieved.setText("0")
                bind.amountRecieved.isFocusable = false
                bind.amountRecieved.isEnabled = false


            }
        }
    }

    private fun createOrder() {
        timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().time)


        // invoice number will be added at run time

        if (!args.editFlag) {
            createOrder.temp_invoice_number = timeStamp
        } else {
            createOrder.temp_invoice_number = data.temp_invoice_number
            createOrder.id = data.id
            createOrder.invoiceId = data.invoiceId

        }



        createOrder.date = getFinalDateValidUptoSend(todayDate()!!)
        createOrder.companyName = preferences?.companyName
        createOrder.taxType = if (preferences!!.isInclusive) {
            "1" // 1 means Inclusive
        } else {
            "0" // 2 means exclusive
        }
        createOrder.dueTerm = "0"

        createOrder.variant = 2
        createOrder.userId = preferences?.userId
        createOrder.company_id = preferences?.companyId


        /*-------------------------------------------------------------------*/
        //page one details
        createOrder.products = args.productDetails
        createOrder.subTotal = args.subTotal.toString()
        createOrder.totalBalance = args.total
        //taxes
        createOrder.cessTotal = args.cess
        createOrder.igst = args.igst
        createOrder.cgst = args.cgst
        createOrder.sgst = args.sgst
        createOrder.discount = "0"
        createOrder.discountStatus = ""
        /*-------------------------------------------------------------------*/
        //page two details
        createOrder.mobile = args.mobile
        createOrder.gstin = args.gstin

        createOrder.placeOfSupply = if (args.placeOfSupply == "Place of Supply") {
            ""
        } else {
            args.placeOfSupply
        }

        createOrder.customer_name = args.contactName
        createOrder.address = args.address
        createOrder.state = args.state
        createOrder.city = args.state
        createOrder.pincode = args.pincode
        createOrder.customerEmail = args.email
        /*-------------------------------------------------------------------*/
        //page three details
        createOrder.modePayment = modeOfPayment
        createOrder.balanceDue = bind.dueAmount.text.toString()
        createOrder.amountReceived = bind.amountRecieved.text.toString()
        createOrder.change = bind.change.text.toString()

        CoroutineScope(Dispatchers.Main).launch {

            openDialog()
        }
    }

    private fun openDialog() {
        val succesDialog =
            OrderCreated(
                "Order Placed \nOrder ID: ${createOrder.temp_invoice_number}",
                this@ModeOfPayment,
                createOrder
            )
        succesDialog.showNow(parentFragmentManager, "SANJAY")
    }

    private fun enableAmountRecieved() {
        bind.amountRecieved.setText("")

        bind.amountRecieved.isEnabled = true
        bind.amountRecieved.isFocusable = true

        bind.amountRecieved.requestFocus()

        bind.amountRecieved.isFocusableInTouchMode = true
        bind.amountRecieved.isClickable = true
    }

    override fun newOrder() {

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.createOfflineInvoice(createOrder)
        }

        requireView().findNavController().navigate(R.id.modeOfPayment_to_dashboard)

    }

    override fun editOrder(createOrder: CreateOrderr) {
        val action =
            ModeOfPaymentDirections.modeOfPaymentToDashboard(Gson().toJson(createOrder), false)
        requireView().findNavController().navigate(action)

    }

}