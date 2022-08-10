package app.instabillpos.ui.frags.contacydetails

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import app.instabillpos.R
import app.instabillpos.databinding.CustomerDetailsBinding
import app.instabillpos.mProguard.Model.CreateOrderr
import app.instabillpos.mProguard.Model.StateData
import app.instabillpos.utils.mUtil.hideKeyboard
import app.instabillpos.utils.mUtil.isOnline
import app.instabillpos.utils.mUtil.isValidText
import app.instabillpos.utils.mUtil.mLog
import app.instabillpos.utils.mUtil.mToast
import com.google.gson.Gson
import com.google.gson.JsonParser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CustomerDetails : Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    private var _binding: CustomerDetailsBinding? = null
    private val bind get() = _binding!!
    val args: CustomerDetailsArgs by navArgs()
    private val viewModel: CustomerDetailsViewModel by viewModels()
    var flag = false
    var state = ""
    var id = ""
    private val stateArrayList: ArrayList<StateData> = ArrayList<StateData>()
    var stateNameList = ArrayList<String>()
    var supplyCode = ""
    var adapter: ArrayAdapter<String>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CustomerDetailsBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
        hideKeyboradOnFocusChanges()

        CoroutineScope(Dispatchers.Main).launch {
            getStates()
        }
        setUpEditData()
    }

    private fun setUpEditData() {
        mLog("EDIT DATA :: " + args.editData)
        if (args.editData.isNotEmpty()) {
            if (args.editData.trim().isNotEmpty()) {
                val data =
                    Gson().fromJson(JsonParser().parse(args.editData), CreateOrderr::class.java)
                bind.mobile.setText(data.mobile)
                bind.gstin.setText(data.gstin)
                bind.name.setText(data.customer_name)
                bind.address.setText(data.address)
                bind.city.setText(data.city)
                bind.pinCode.setText(data.pincode)
                bind.email.setText(data.customerEmail)
            }
        }
    }

    private suspend fun getStates() {
        var states = viewModel.getState()
        if (states.data?.errorCode.equals("0")) {
            stateArrayList.clear()
            stateArrayList.addAll(
                states.data!!.data
            )
            stateNameList.clear()
            stateNameList.add("Place of Supply")
            for (i in stateArrayList.indices) {
                stateNameList.add(
                    stateArrayList[i].stateName
                )
            }
            setStates()

        }
    }

    private fun setStates() {

        // stateNameList.add(getString(R.string.place_of_supply));
        adapter = ArrayAdapter<String>(
            requireContext(),
            R.layout.row_spinner,
            stateNameList
        )
        bind.placeOfSupply.adapter = adapter
        bind.placeOfSupply.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {

            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        })
    }

    private fun hideKeyboradOnFocusChanges() {
        bind.mobile.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(requireContext(), requireView())
            }
        }
        bind.whatsapp.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(requireContext(), requireView())
            }
        }
        bind.name.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(requireContext(), requireView())
            }
        }
        bind.address.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(requireContext(), requireView())
            }
        }
        bind.state.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(requireContext(), requireView())
            }
        }
        bind.city.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(requireContext(), requireView())
            }
        }

        bind.pinCode.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(requireContext(), requireView())
            }
        }


        bind.email.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(requireContext(), requireView())
            }
        }
    }

    private fun initAllComponents() {
        bind.next.setOnClickListener(this)
        bind.back.setOnClickListener(this)
        bind.sameAsMobile.setOnClickListener(this)
        bind.prefillDetails.setOnClickListener(this)
        bind.gstin.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().isNotEmpty()) {
                    if (p0.toString().length > 1) {
                        for (i in stateArrayList.indices) {
                            if (p0.toString() == stateArrayList[i].stateCode) {
                                val spinnerPosition: Int =
                                    adapter!!.getPosition(stateArrayList[i].stateName)
                                bind.placeOfSupply.setSelection(spinnerPosition)
                            }
                        }


                        if (p0.toString().length == 15) {
                            fetchData(p0.toString())
                            mToast(requireContext(), "get data from api")
                        }
                    }
                } else {
                    bind.placeOfSupply.setSelection(0)
                }
            }
        })
        bind.state.onItemSelectedListener = this

        bind.mobile.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().length == 10) {
                    bind.prefillDetails.performClick()
                }
            }
        })
    }

    private fun fetchData(gstNumber: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val gstData = viewModel.fetchGSTData(gstNumber).data;
            mLog(Gson().toJson(gstData))
            if (gstData?.status.equals("success")) {
                bind.name.setText(gstData?.data?.legalNameOfBusiness)
                bind.address.setText(gstData?.data?.address)

                val spinnerPosition: Int =
                    adapter!!.getPosition(gstData?.data?.stateName?.toUpperCase())
                bind.state.setSelection(spinnerPosition)
                bind.city.setText(gstData?.data?.city)
                bind.pinCode.setText(gstData?.data?.pincode)
            }
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.next -> {
                if (isValidText(bind.mobile.text.toString().trim(), bind.mobile) &&
                    isValidText(bind.name.text.toString().trim(), bind.name)
                ) {
                    if (isOnline(requireContext())) {
                        if (flag) {
                            mLog("Already Customer")
                            editCustomer()
                        } else {
                            mLog("Create Customer")
                            createCustomer()
                        }
                    } else {
                        MoveToNextPage(v)
                    }

                }
            }
            R.id.back -> {
                v.findNavController().navigateUp()
            }
            R.id.same_as_mobile -> {
                bind.whatsapp.setText(bind.mobile.text.toString().trim())
            }
            R.id.prefillDetails -> {
                CoroutineScope(Dispatchers.Main).launch {
                    bind.progressBar.visibility = VISIBLE
                    val data = viewModel.getCustomerDetail(bind.mobile.text.toString()).data?.data
                    bind.progressBar.visibility = GONE
                    if (data != null) {
                        if (data.id != null) {
                            id = data.id.toString()
                        }


                        if (!data.name.isNullOrEmpty()) {
                            flag = true
                            bind.name.setText(data.name)
                        }

                        if (!data.address.isNullOrEmpty()) {
                            bind.address.setText(data.address)
                        }

                        if (data.pincode != null) {
                            bind.pinCode.setText(data.pincode)
                        }

                        if (!data.email.isNullOrEmpty()) {
                            bind.email.setText(data.email)
                        }
                        if (!data.pincode.isNullOrEmpty()) {
                            bind.pinCode.setText(data.pincode)
                        }
                        if (!data.city.isNullOrEmpty()) {
                            bind.city.setText(data.city)
                        }
                        if (!data.state.isNullOrEmpty()) {
                            val compareValue = data.state
                            val adapter = ArrayAdapter.createFromResource(
                                requireContext(),
                                R.array.states,
                                android.R.layout.simple_spinner_item
                            )
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            bind.state.adapter = adapter
                            if (compareValue != null) {
                                val spinnerPosition = adapter.getPosition(compareValue)
                                bind.state.setSelection(spinnerPosition)
                            }
                        }

                    } else {
                        flag = false
                    }

                }

            }
        }
    }

    private fun editCustomer() {
        CoroutineScope(Dispatchers.Main).launch {
            bind.progressBar.visibility = VISIBLE
            val data = viewModel.editCustomer(
                id,
                bind.name.text.toString(),
                bind.name.text.toString(),
                bind.address.text.toString(),
                bind.mobile.text.toString(),
                bind.email.text.toString(),
                bind.city.text.toString(),
                bind.pinCode.text.toString(),
                state
            ).data
            mLog(Gson().toJson(data))
            if (data?.errorCode.equals("0")) {
                bind.progressBar.visibility = GONE
                MoveToNextPage(requireView())
            } else {
                bind.progressBar.visibility = GONE
                data?.errorMsg?.let { mToast(requireContext(), it) }
            }
        }
    }

    private fun createCustomer() {
        CoroutineScope(Dispatchers.Main).launch {
            bind.progressBar.visibility = VISIBLE
            val data = viewModel.addCustomer(
                bind.name.text.toString(),
                bind.name.text.toString(),
                bind.address.text.toString(),
                bind.mobile.text.toString(),
                bind.email.text.toString(),
                bind.city.text.toString(),
                bind.pinCode.text.toString(),
                state
            ).data
            mLog(Gson().toJson(data))
            if (data?.errorCode.equals("0")) {
                bind.progressBar.visibility = GONE
                MoveToNextPage(requireView())
            } else {
                bind.progressBar.visibility = GONE
                data?.errorMsg?.let { mToast(requireContext(), it) }
            }
        }
    }

    private fun MoveToNextPage(v: View) {
        val action = CustomerDetailsDirections.customerDetailsToModeOfPayment(
            bind.mobile.text.toString(),
            bind.whatsapp.text.toString(),
            bind.name.text.toString(),
            bind.address.text.toString(),
            state,
            bind.city.text.toString(),
            bind.pinCode.text.toString(),
            bind.email.text.toString(),
            args.subTotal,
            args.productDetails,
            args.igst,
            args.cgst,
            args.sgst,
            args.total,
            bind.gstin.text.toString(),
            if (bind.placeOfSupply.selectedItem == null) {
                ""
            } else {
                bind.placeOfSupply.selectedItem.toString()
            },
            args.cess,
            args.editData,
            args.editFlag
        )
        v.findNavController().navigate(action)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p2 != 0) {
            when (p0?.id) {
                R.id.state -> {
                    state = p0.selectedItem.toString()
                }
            }
        } else {
            state = ""
        }

        mLog("STATE : $state")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        when (p0?.id) {
            R.id.state -> {
                state = ""
            }
        }
        mLog("STATE : $state")
    }


}