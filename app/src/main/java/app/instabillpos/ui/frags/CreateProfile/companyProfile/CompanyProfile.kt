package app.instabillpos.ui.frags.CreateProfile.companyProfile

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import app.instabillpos.R
import app.instabillpos.databinding.CompanyProfileBinding
import app.instabillpos.mProguard.Model.GstDetailResponse
import app.instabillpos.mProguard.Model.StateData
import app.instabillpos.ui.activity.MainActivity.MainActivity
import app.instabillpos.utils.mUtil.isValidText
import app.instabillpos.utils.mUtil.mToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class CompanyProfile : Fragment(), View.OnClickListener {


    private var flag: Int = 0
    private var _binding: CompanyProfileBinding? = null
    private val bind get() = _binding!!

    private val stateArrayList = ArrayList<StateData>()
    val args: CompanyProfileArgs by navArgs()
    private val viewModel: CompanyProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CompanyProfileBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAllComponents()

        addAutoGst()
    }

    private fun addAutoGst() {
        bind.etGstin.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(string: CharSequence, start: Int, before: Int, count: Int) {
                if (string.length <= 2 && string.length >= 1) {
                    /*if (string.toString().matches("[0-9]+")) {
                        if (string.length == 2) {
                            if (!validateGSTN(string.toString())) {
                                // Log.d("validais"," value "+validateGSTN(string.toString()));
                                bind.etGstin.setFilters(arrayOf<InputFilter>(LengthFilter(2)))
                                bind.etGstin.setError(resources.getString(R.string.invalid_gstin_number))
                            }
                        } else {
                            bind.etGstin.setError(null)
                            bind.etGstin.setFilters(arrayOf<InputFilter>(LengthFilter(15)))
                        }
                    } else {
                        bind.etGstin.setFilters(arrayOf<InputFilter>(LengthFilter(2)))
                        bind.etGstin.setError(resources.getString(R.string.gstin_start_with_digit))
                    }*/
                } else {
                    bind.etGstin.setFilters(arrayOf<InputFilter>(InputFilter.LengthFilter(15)))
                    bind.etGstin.setError(null)
                }
                /* if (string.length == 0) {
                     switchComposite.setChecked(false)
                 }*/
                //gstIN = string.toString()
            }

            override fun afterTextChanged(s: Editable) {}
        })

        bind.etGstin.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (bind.etGstin.text!!.length == 15) {

                fetchData(bind.etGstin.text.toString())
            }
        }
    }

    private fun fetchData(gstIN: String) {
        (activity as MainActivity).showLoader()
        CoroutineScope(Dispatchers.Main).launch {
            val response = viewModel.fetchGSTUserData(gstIN)
            if (response.data?.status == "success") {
                setuserData(response.data.data)
                (activity as MainActivity).hideLoader()
            }else{
                (activity as MainActivity).hideLoader()
            }
        }
    }
    private fun setuserData(data: GstDetailResponse.GSTResponseData) {

        bind.companyName.setText(data.tradeName)
        bind.address.setText(data.street + data.buildingName + data.location + data.stateName)
        bind.pinCode.setText(data.pincode)
        flag = if (data.taxpayerType.equals("Composition")) {
            1
        } else {
            0
        }

    }

    private fun validateGSTN(toString: String): Boolean {
        val code = toString.substring(0, 2)
        for (i in stateArrayList.indices) {
            if (code == stateArrayList[i].stateCode) {
                return true
            }
        }
        return false
    }

    private fun initAllComponents() {
        bind.next.setOnClickListener(this)
        bind.previous.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.next -> {
                if (isValidText(bind.companyName.text.toString().trim(), bind.companyName)) {

                    if (bind.spinner.selectedItem.equals("Type of Entity *")) {
                        mToast(requireContext(), "Select Type of Entity")
                    } else {
                        val action = CompanyProfileDirections.companyProfileToContectDetails(
                            args.bussinessType,
                            args.imagePath,
                            bind.spinner.selectedItem.toString(),
                            bind.etGstin.text.toString().trim(),
                            bind.companyName.text.toString().trim(),
                            bind.address.text.toString().trim(),
                            bind.pinCode.text.toString().trim(),
                            flag
                        )
                        v.findNavController().navigate(action)
                        //mToast(requireContext(),"yes")
                    }

                }
                //navController.navigate(R.id.companyProfile_to_contectDetails)
            }
            R.id.previous -> {
                v.findNavController().navigateUp()
            }
        }
    }


/* private fun setuserData(data: GSTResponseData?) {

     bind.companyName.setText(data!!.tradeName)
     bind.address.setText(data.street + data.buildingName + data.location + data.stateName)
     bind.pinCode.setText(data.pincode)
     flag = if (data.taxpayerType.equals("Composition")) {
         1
     } else {
         0
     }

 }*/

}