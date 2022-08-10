package app.instabillpos.ui.frags.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.view.View.*
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import app.instabillpos.R
import app.instabillpos.databinding.DashboardBinding
import app.instabillpos.mProguard.Model.CreateOrderr
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import app.instabillpos.repository.entities.products.Data
import app.instabillpos.repository.utils.Resource
import app.instabillpos.utils.mUtil.formatDoubleToTwoDecimals
import app.instabillpos.utils.mUtil.funCalculateGst
import app.instabillpos.utils.mUtil.hideKeyboard
import app.instabillpos.utils.mUtil.mLog
import app.instabillpos.utils.mUtil.mToast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Dashboard : Fragment(), OnClickListener, DashBoardAdapter.ItemListener,
    OrderDetailAdapter.ItemListener, NavigationView.OnNavigationItemSelectedListener {

    private var _binding: DashboardBinding? = null
    private val bind get() = _binding!!
    private val viewModel: DashBoardViewModel by viewModels()

    private lateinit var mAdapter: DashBoardAdapter
    private lateinit var mAdapterOrderDetail: OrderDetailAdapter
    var searchedName = ""
    var searchResult = ArrayList<Data>()
    var allResult = ArrayList<Data>()
    var allOrderDetailItem = ArrayList<Data>()
    var subTotal: Double = 0.0

    val args: DashboardArgs by navArgs()

    //taxes
    var cgst: Double = 0.0
    var sgst: Double = 0.0
    var igst: Double = 0.0
    var cess: Double = 0.0
    var total: Double = 0.0

    var sharedPref: AppSharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DashboardBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAllComponents()
        setUpRecyclerView()
        setUpSideNavigation()

        setupObservers()
        setUpSearch()
        setUpOrderDetailRecyclerView()
        mAdapterOrderDetail.setItems(allOrderDetailItem)

        hideKeyboradOnFocusChanges()
        hideSystemUI()

        setUpEditData()
    }

    private fun setUpEditData() {
        if (!args.data.isNullOrEmpty()) {
            if (args.data!!.trim().isNotEmpty()) {
                val data = Gson().fromJson(JsonParser().parse(args.data), CreateOrderr::class.java)

                val products = data.products

                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()

                val productsArray: Array<Data> = gson.fromJson(
                    products,
                    Array<Data>::class.java
                )
                allOrderDetailItem.clear()
                for (i in productsArray.indices) {

                    /*
                    *  "id": "68945",
            "company_id": "6952",
            "user_id": "37",
            "name": "BMW",
            "description": "bnefsdf",
            "product_type": "",
            "product_rate": "50",
            "product_unit": "",
            "hsn": "5445",
            "tax_rate": "20",
            "cess_charge": "0",
            "discount": "1",
            "discount_value": "0",
            "import_id": "0",
            "barcode_id": "0",
            "purchase_status": "1",
            "sku": "Test1",
            "reorder_level": "",
            "opening_stock_quantity": "0",
            "opening_stock_value": "0",
            "reorder_level_quantity": "0",
            "product_status": "1",
            "raw_materail_status": "0",
            "purchase_inventory_status": "0",
            "sales_inventory_status": "1",
            "track_inventory_status": "0",
            "date": "",
            "purchase_rate": "0",
            "purchase_description": "",
            "product_categorey": "",
            "batch_no": "",
            "manufacturing_date": "",
            "expiry_date": "",
            "mrp": "",
            "image": "",
            "product_categorey_old": 0,
            "created": "2022-01-21 07:08:10",
            "unit_id": "",
            "title": "",
            "current_quantity": "0.00"*/


                    productsArray[i].name =
                        CustomNullCheckAsPerSunill(productsArray[i].name)
                    productsArray[i].description =
                        CustomNullCheckAsPerSunill(productsArray[i].description)
                    productsArray[i].productType =
                        CustomNullCheckAsPerSunill(productsArray[i].productType)
                    productsArray[i].productRate =
                        CustomNullCheckAsPerSunill(productsArray[i].productRate)
                    productsArray[i].productUnit =
                        CustomNullCheckAsPerSunill(productsArray[i].productUnit)
                    productsArray[i].hsn =
                        CustomNullCheckAsPerSunill(productsArray[i].hsn)
                    productsArray[i].taxRate =
                        CustomNullCheckAsPerSunill(productsArray[i].taxRate)
                    productsArray[i].cessCharge =
                        CustomNullCheckAsPerSunill(productsArray[i].cessCharge)
                    productsArray[i].discount =
                        CustomNullCheckAsPerSunill(productsArray[i].discount)
                    productsArray[i].discountValue =
                        CustomNullCheckAsPerSunill(productsArray[i].discountValue)
                    productsArray[i].importId =
                        CustomNullCheckAsPerSunill(productsArray[i].importId)
                    productsArray[i].barcodeId =
                        CustomNullCheckAsPerSunill(productsArray[i].barcodeId)
                    productsArray[i].purchaseStatus =
                        CustomNullCheckAsPerSunill(productsArray[i].purchaseStatus)
                    productsArray[i].sku =
                        CustomNullCheckAsPerSunill(productsArray[i].sku)
                    productsArray[i].reorderLevel =
                        CustomNullCheckAsPerSunill(productsArray[i].reorderLevel)
                    productsArray[i].openingStockQuantity =
                        CustomNullCheckAsPerSunill(productsArray[i].openingStockQuantity)
                    productsArray[i].openingStockValue =
                        CustomNullCheckAsPerSunill(productsArray[i].openingStockValue)
                    productsArray[i].reorderLevelQuantity =
                        CustomNullCheckAsPerSunill(productsArray[i].reorderLevelQuantity)
                    productsArray[i].productStatus =
                        CustomNullCheckAsPerSunill(productsArray[i].productStatus)
                    productsArray[i].rawMaterailStatus =
                        CustomNullCheckAsPerSunill(productsArray[i].rawMaterailStatus)
                    productsArray[i].purchaseInventoryStatus =
                        CustomNullCheckAsPerSunill(productsArray[i].purchaseInventoryStatus)
                    productsArray[i].salesInventoryStatus =
                        CustomNullCheckAsPerSunill(productsArray[i].salesInventoryStatus)
                    productsArray[i].trackInventoryStatus =
                        CustomNullCheckAsPerSunill(productsArray[i].trackInventoryStatus)
                    productsArray[i].purchaseRate =
                        CustomNullCheckAsPerSunill(productsArray[i].purchaseRate)
                    productsArray[i].purchaseDescription =
                        CustomNullCheckAsPerSunill(productsArray[i].purchaseDescription)
                    productsArray[i].productCategorey =
                        CustomNullCheckAsPerSunill(productsArray[i].productCategorey)



                    addItemToCard(productsArray[i], true)
                }
                mLog("Order DATA TWO:: " + Gson().toJson(data))
            }

        }
    }

    private fun CustomNullCheckAsPerSunill(value: String?): String {
        return if (value.isNullOrEmpty()) {
            " "
        } else {
            value
        }
    }

    private fun setUpSideNavigation() {
        bind.navView.setNavigationItemSelectedListener(this)
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        requireActivity().window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    private fun showSystemUI() {
        requireActivity().window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    private fun hideKeyboradOnFocusChanges() {
        bind.appBarMain.dashboard.search.onFocusChangeListener =
            OnFocusChangeListener { v, hasFocus ->
                if (!hasFocus) {
                    hideKeyboard(requireContext(), v)
                }
            }

        bind.appBarMain.dashboard.cess.onFocusChangeListener =
            OnFocusChangeListener { v, hasFocus ->
                if (!hasFocus) {
                    hideKeyboard(requireContext(), v)
                }
            }
    }


    private fun setUpOrderDetailRecyclerView() {
        mAdapterOrderDetail = OrderDetailAdapter(requireContext(), Dashboard@ this)
        bind.appBarMain.dashboard.orderDetailRecycler.layoutManager =
            LinearLayoutManager(requireContext())
        bind.appBarMain.dashboard.orderDetailRecycler.adapter = mAdapterOrderDetail

        bind.appBarMain.dashboard.navDrawer.setOnClickListener(this)
        bind.appBarMain.dashboard.clearCart.setOnClickListener(this)

    }

    private fun setUpSearch() {
        bind.appBarMain.dashboard.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                searchedName = s.toString().toLowerCase()
                searchResult.clear()
                for (i in 0 until allResult.size) {
                    if (allResult[i].name!!.toLowerCase().contains(searchedName)) {
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



        bind.appBarMain.dashboard.search.setOnTouchListener(OnTouchListener { v, event ->
            val DRAWABLE_RIGHT = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= bind.appBarMain.dashboard.search.right - bind.appBarMain.dashboard.search.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                ) {
                    bind.appBarMain.dashboard.search.setText("")
                    bind.appBarMain.dashboard.searchContainer.visibility = GONE
                    bind.appBarMain.dashboard.menuBar.visibility = VISIBLE
                    return@OnTouchListener true
                }
            }
            false
        })

    }


    private fun setUpRecyclerView() {
        mAdapter = DashBoardAdapter(requireContext(), Dashboard@ this)
        bind.appBarMain.dashboard.productRecycler.layoutManager =
            GridLayoutManager(requireContext(), 4)
        bind.appBarMain.dashboard.productRecycler.adapter = mAdapter
    }

    private fun initAllComponents() {
        sharedPref = AppSharedPreferences.getInstance(requireContext())
        bind.appBarMain.dashboard.searchBT.setOnClickListener(this)

        bind.appBarMain.dashboard.next.setOnClickListener(this)
        bind.appBarMain.dashboard.sync.setOnClickListener(this)
        activity?.findViewById<TextView>(R.id.toolbar)?.text = "Order No. 1234"

        activity?.findViewById<TextView>(R.id.time)?.visibility = VISIBLE


        val header: View = bind.navView.getHeaderView(0)
        val name = header.findViewById<View>(R.id.name) as TextView
        val email = header.findViewById<View>(R.id.email) as TextView
        val companyImage = header.findViewById<View>(R.id.companyImage) as ImageView
        name.text = sharedPref?.companyName
        email.text = sharedPref?.emailId

        Glide.with(requireContext())
            .load(sharedPref?.companyImage)
            .error(R.drawable.sample_image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(companyImage);

        bind.appBarMain.dashboard.cess.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().isNotEmpty()) {
                    cess = p0.toString().toDouble()

                    refreshOrderDetail()
                } else {
                    cess = 0.0
                }
            }
        })
    }

    private fun setupObservers() {
        viewModel.products.observeForever {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) {
                        allResult = ArrayList(it.data)
                        mAdapter.setItems(allResult)
                    }
                }
                Resource.Status.ERROR -> {
                    Log.i("SANJAY", "setupObservers: ERROR  ${it.message}")
                    //Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }

                Resource.Status.LOADING -> {
                    Log.i("SANJAY", "setupObservers: LOADING")
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.searchBT -> {
                if (bind.appBarMain.dashboard.searchContainer.visibility == VISIBLE) {
                    bind.appBarMain.dashboard.search.setText("")
                    bind.appBarMain.dashboard.searchContainer.visibility = GONE
                    bind.appBarMain.dashboard.menuBar.visibility = VISIBLE
                } else {
                    bind.appBarMain.dashboard.menuBar.visibility = GONE
                    bind.appBarMain.dashboard.searchContainer.visibility = VISIBLE
                    bind.appBarMain.dashboard.search.requestFocus()


                    //open keyboard
                    val imm: InputMethodManager? =
                        requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
                    imm?.showSoftInput(
                        bind.appBarMain.dashboard.search,
                        InputMethodManager.SHOW_IMPLICIT
                    )
                }
            }
            R.id.next -> {
                mLog("Total :: $total")
                if (allOrderDetailItem.size > 0) {
                    val action = DashboardDirections.dashboardToCustomerDetails(
                        subTotal.toFloat(),
                        Gson().toJson(allOrderDetailItem).toString(),
                        igst.toString(),
                        cgst.toString(),
                        sgst.toString(),
                        total.toString(),
                        bind.appBarMain.dashboard.cess.text.toString(),
                        args.data.toString(),
                        args.editApiFlag
                    )
                    v.findNavController().navigate(action)
                } else {
                    mToast(requireContext(), "Add item to checkout")
                }
            }
            R.id.navDrawer -> {
                bind.drawerLayout.open()
            }
            R.id.sync -> {

                setupObservers()
            }
            R.id.clearCart -> {
                allOrderDetailItem.clear()
                refreshOrderDetail()
            }
        }
    }

    override fun addItemToCard(data: Data, editFlag: Boolean) {
        if (editFlag) {
            allOrderDetailItem.add(data)
        } else {
            if (!data.name.isNullOrEmpty() && !data.productRate.isNullOrEmpty()) {
                var flag = true
                if (allOrderDetailItem.isNotEmpty()) {
                    for (i in 0 until allOrderDetailItem.size) {
                        flag = true
                        if (allOrderDetailItem[i].name.equals(data.name)
                        ) {


                            data.productType =
                                (Integer.parseInt(allOrderDetailItem[i].productType) + 1).toString()

                            allOrderDetailItem.add(data)

                            allOrderDetailItem.removeAt(i)

                            flag = false
                            break
                        }
                    }
                }
                if (flag) {
                    data.productType = "1"
                    allOrderDetailItem.add(data)
                }

            }
        }
        refreshOrderDetail()
    }


    override fun subtract(data: Data, position: Int) {
        if (data.productType.equals("1")) {
            allOrderDetailItem.removeAt(position)
        } else {
            data.productType = (data.productType!!.toInt() - 1).toString()
            allOrderDetailItem.removeAt(position)
            allOrderDetailItem.add(position, data)

        }
        refreshOrderDetail()
    }

    override fun add(data: Data, position: Int) {
        data.productType = (data.productType!!.toInt() + 1).toString()
        allOrderDetailItem.removeAt(position)
        allOrderDetailItem.add(position, data)
        refreshOrderDetail()
    }

    fun refreshOrderDetail() {

        subTotal = 0.0

        for (j in allOrderDetailItem.indices) {
            subTotal =
                (subTotal + allOrderDetailItem[j].productType!!.toDouble() * allOrderDetailItem[j].productRate!!.toDouble())

        }

        subTotal = formatDoubleToTwoDecimals(subTotal)

        if (sharedPref!!.isGSTAvail) {
            calculateTaxes()

            //if Cess is on
            if (sharedPref!!.isCessActive) {
                bind.appBarMain.dashboard.cessContainer.visibility = VISIBLE
            } else {
                cess = 0.0
                bind.appBarMain.dashboard.cess.setText("")
                bind.appBarMain.dashboard.cessContainer.visibility = GONE
            }

        }

        //subTotal
        bind.appBarMain.dashboard.subTotal.text = "₹ ${formatDoubleToTwoDecimals(subTotal)}"

        //total amount
        total = formatDoubleToTwoDecimals(
            formatDoubleToTwoDecimals(subTotal) +
                    formatDoubleToTwoDecimals(cgst) +
                    formatDoubleToTwoDecimals(sgst) +
                    formatDoubleToTwoDecimals(igst) +
                    formatDoubleToTwoDecimals(cess)
        )
        bind.appBarMain.dashboard.total.text = "₹ $total"


        mAdapterOrderDetail.setItems(allOrderDetailItem)
        hideKeyboard(requireContext(), requireView())
    }

    private fun calculateTaxes() {
        // if Same state or compostion is on
        // true means same state and composition is on
        if (sharedPref!!.companyCompositionValue) {
            bind.appBarMain.dashboard.igstContainer.visibility = GONE
            igst = 0.0

            bind.appBarMain.dashboard.cgstContainer.visibility = VISIBLE
            bind.appBarMain.dashboard.sgstContainer.visibility = VISIBLE


            //true means excluding
            //false means including
            if (!sharedPref!!.isInclusive) {
                bind.appBarMain.dashboard.inclusiveNote.text = "Prices are exclusive of GST"
                cgst = formatDoubleToTwoDecimals(
                    funCalculateGst(allOrderDetailItem, true) / 2
                )
                sgst = formatDoubleToTwoDecimals(
                    funCalculateGst(allOrderDetailItem, true) / 2
                )
            } else {
                bind.appBarMain.dashboard.inclusiveNote.text = "Prices are inclusive of GST"
                cgst = formatDoubleToTwoDecimals(
                    funCalculateGst(allOrderDetailItem, false) / 2
                )
                sgst = formatDoubleToTwoDecimals(
                    funCalculateGst(allOrderDetailItem, false) / 2
                )

                subTotal -= formatDoubleToTwoDecimals(
                    funCalculateGst(allOrderDetailItem, false)
                )

            }


            bind.appBarMain.dashboard.sgst.text = cgst.toString()
            bind.appBarMain.dashboard.cgst.text = sgst.toString()


        }
        //if different state
        else {
            cgst = 0.0
            sgst = 0.0
            bind.appBarMain.dashboard.sgstContainer.visibility = GONE
            bind.appBarMain.dashboard.cgstContainer.visibility = GONE

            bind.appBarMain.dashboard.igstContainer.visibility = VISIBLE

            if (sharedPref!!.isInclusive) {
                bind.appBarMain.dashboard.inclusiveNote.text = "Prices are exclusive of GST"
                igst = formatDoubleToTwoDecimals(funCalculateGst(allOrderDetailItem, true))
            } else {
                bind.appBarMain.dashboard.inclusiveNote.text = "Prices are inclusive of GST"
                igst = formatDoubleToTwoDecimals(funCalculateGst(allOrderDetailItem, false))
                subTotal -= formatDoubleToTwoDecimals(
                    funCalculateGst(allOrderDetailItem, false)
                )
            }

            bind.appBarMain.dashboard.igstContainer.visibility = VISIBLE
            igst = formatDoubleToTwoDecimals(funCalculateGst(allOrderDetailItem, true))

            bind.appBarMain.dashboard.igst.text = igst.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        refreshOrderDetail()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareInstaPOS -> {
                val intent2 = Intent()
                intent2.action = "android.intent.action.SEND"
                intent2.putExtra(
                    "android.intent.extra.TEXT",
                    "Here will be sharing demo text"
                )
                intent2.type = "text/plain"
                startActivityForResult(intent2, 201)
            }
            R.id.syncData -> {
                bind.appBarMain.dashboard.sync.performClick()

            }
            R.id.logout -> {
                sharedPref?.clearData()
                requireView().findNavController().navigate(R.id.dashboard_to_loginScreen)

            }
            R.id.Orders -> {
                val orders = DashboardDirections.dashboardToOrders()
                requireView().findNavController().navigate(orders)
            }
            R.id.Customers -> {
                val customer = DashboardDirections.dashboardToCustomers()
                requireView().findNavController().navigate(customer)
            }
            R.id.setting -> {
                val setting = DashboardDirections.dashboardToSetting()
                requireView().findNavController().navigate(setting)
            }
            R.id.Items -> {
                requireView().findNavController().navigate(R.id.dashboard_to_items)
            }
            R.id.reports -> {
                requireView().findNavController().navigate(R.id.dashboard_to_reports)
            }
        }
        bind.drawerLayout.close()
        return true
    }


}