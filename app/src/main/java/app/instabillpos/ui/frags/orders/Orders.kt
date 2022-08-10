package app.instabillpos.ui.frags.orders

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import app.instabillpos.R
import app.instabillpos.databinding.OrdersBinding
import app.instabillpos.mProguard.Model.CreateOrderr
import app.instabillpos.mProguard.Model.getInvoiceListModel
import app.instabillpos.utils.mUtil.mLog
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class Orders : Fragment(), View.OnClickListener, OrderAdapter.ItemListener {

    private var _binding: OrdersBinding? = null
    private val bind get() = _binding!!


    var searchedName = ""

    var offsetValue = 0
    var limitValue = 20
    var searchResult = ArrayList<getInvoiceListModel.Datum>()
    private val viewModel: OrdersViewModel by viewModels()

    private lateinit var mAdapter: OrderAdapter
    var allResult = ArrayList<getInvoiceListModel.Datum>()
    val filterList = ArrayList<getInvoiceListModel.Datum>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OrdersBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
        setUpRecyclerView()
        setUpObserver()
        setUpSearch()

        setUpPaginations()
    }

    private fun setUpPaginations() {
        bind.orderRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    CoroutineScope(Dispatchers.Main).launch {
                        if (bind.progressBar.visibility == GONE) {
                            offsetValue += 20
                            limitValue += 20
                            getMoreEnteries(offsetValue, limitValue, "")
                        }
                    }
                }
            }
        })
    }

    private fun setUpSearch() {
        bind.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                searchedName = s.toString().toLowerCase()
                searchResult.clear()
                for (i in 0 until allResult.size) {
                    if (allResult[i].id!!.toLowerCase().contains(searchedName)) {
                        searchResult.add(allResult[i])

                    } else if (allResult[i].customerName!!.toString().toLowerCase()
                            .contains(searchedName)
                    ) {
                        searchResult.add(allResult[i])
                    }
                }

                if (count == 0) {
                    mAdapter.setItems(allResult)

                } else {
                    mAdapter.setItems(searchResult)
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })

    }

    private fun setUpRecyclerView() {
        mAdapter = OrderAdapter(requireContext(), Orders@ this)
        bind.orderRecycler.adapter = mAdapter
    }


    private fun setUpObserver() {
        CoroutineScope(Dispatchers.Main).launch {
            allResult.clear()
            filterList.clear()

            getMoreEnteries(offsetValue, limitValue, "")
        }
    }

    private suspend fun getMoreEnteries(offsetValue: Int?, limitValue: Int?, searchTerm: String?) {
        bind.progressBar.visibility = VISIBLE
        val invoiceData = if (offsetValue != null) {
            viewModel.getInvoiceList(offsetValue.toString(), limitValue.toString())
        } else {
            filterList.clear()
            bind.search.setText("")
            mAdapter.setItems(filterList)
            viewModel.getInvoiceList(searchTerm.toString())
        }
        if (invoiceData.data?.errorCode == "0") {

            allResult.addAll(invoiceData.data.data)

            //remove contact without name
            for (i in allResult.indices) {
                if (allResult[i].customerName != null) {
                    filterList.add(allResult[i])
                }
            }
            bind.progressBar.visibility = GONE
            mAdapter.setItems(filterList)
        }
    }

    private fun initAllComponents() {
        bind.back.setOnClickListener(this)
        bind.searchButton.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back -> {
                requireView().findNavController().popBackStack()
            }
            R.id.searchButton -> {
                if (bind.search.text.toString().isNotEmpty()) {
                    CoroutineScope(Dispatchers.Main).launch {
                        getMoreEnteries(null, null, bind.search.text.toString())
                    }
                }

            }
        }
    }

    override fun onOrderSelected(data: getInvoiceListModel.Datum) {
        mLog("EDIT DATA :: " + Gson().toJson(data))

        val createOrder = CreateOrderr()

        //page one data
        createOrder.products = Gson().toJson(data.userInvoiceProduct)

        //page two data
        createOrder.mobile = data.mobile?.toString()
        createOrder.gstin = data.gstin?.toString()
        createOrder.customer_name = data.customerName?.toString()
        createOrder.address = data.address?.toString()
        createOrder.pincode = data.pincode?.toString()
        createOrder.customerEmail = data.customerEmail?.toString()

        //page three
        createOrder.amountReceived = data.amountReceived?.toString()
        createOrder.modePayment = data.paymentMode?.toString()


        //edit Invoice Data
        createOrder.temp_invoice_number = data.tempInvoiceNumber?.toString()
        createOrder.id = data.id?.toString()
        createOrder.invoiceId = data.invoiceId?.toString()



        mLog("Order DATA ONE :: ${Gson().toJson(createOrder)}")
        val action = OrdersDirections.ordersToDashboard(Gson().toJson(createOrder).toString(), true)
        requireView().findNavController().navigate(action)
    }

}