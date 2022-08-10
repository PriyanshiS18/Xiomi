package app.instabillpos.ui.frags.customers

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import app.instabillpos.R
import app.instabillpos.databinding.CustomersBinding
import app.instabillpos.mProguard.Model.CustomerListModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Customers : Fragment(), CustomersAdapter.ItemListener, View.OnClickListener {


    private var _binding: CustomersBinding? = null
    private val bind get() = _binding!!


    private val viewModel: CustomersViewModel by viewModels()

    private lateinit var mAdapter: CustomersAdapter
    var allResult = ArrayList<CustomerListModel.Datum>()

    var searchedName = ""
    var searchResult = ArrayList<CustomerListModel.Datum>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CustomersBinding.inflate(inflater, container, false)
        return bind.root
    }

    private fun setUpRecyclerView() {
        mAdapter = CustomersAdapter(requireContext(), Customers@ this)
        bind.customerRecycler.adapter = mAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
        setUpRecyclerView()
        setUpObserver()
        setUpSearch()
    }

    private fun setUpSearch() {
        bind.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                searchedName = s.toString().toLowerCase()
                searchResult.clear()
                for (i in 0 until allResult.size) {
                    if (allResult[i].name != null) {
                        if (allResult[i].mobile!!.toLowerCase().contains(searchedName)) {
                            searchResult.add(allResult[i])

                        }
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

    private fun setUpObserver() {
        CoroutineScope(Dispatchers.Main).launch {
            val customerData = viewModel.getCustomer()
            if (customerData.data?.errorCode == "0") {

                allResult.clear()
                allResult.addAll(customerData.data.data)


                //remove contact without name
                val filterList = ArrayList<CustomerListModel.Datum>()
                for (i in allResult.indices) {
                    if (allResult[i].name != null) {
                        filterList.add(allResult[i])
                    }
                }
                bind.progressBar.visibility = GONE
                mAdapter.setItems(filterList)
                //mLog(Gson().toJson(customerData.data.data))
            }
        }
    }

    private fun initAllComponents() {
        bind.back.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back -> {
                requireView().findNavController().popBackStack()
            }
        }
    }

}