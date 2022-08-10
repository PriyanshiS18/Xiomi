package app.instabillpos.ui.frags.CreateProfile.contactdetails

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import app.instabillpos.R
import app.instabillpos.databinding.ContectDetailsBinding
import app.instabillpos.mProguard.Model.CreateProfileRes
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import app.instabillpos.ui.activity.MainActivity.MainActivity
import app.instabillpos.utils.mUtil
import app.instabillpos.utils.mUtil.showDeviceInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class contectDetails : Fragment(), View.OnClickListener {


    private var _binding: ContectDetailsBinding? = null
    private val bind get() = _binding!!
    val args: contectDetailsArgs by navArgs()
    private var progressDialog: ProgressDialog? = null
    private lateinit var preferences: AppSharedPreferences

    private val viewModel: ContactDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ContectDetailsBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
    }

    private fun initAllComponents() {
        progressDialog = ProgressDialog(requireContext())

        bind.next.setOnClickListener(this)
        bind.previous.setOnClickListener(this)
        preferences = AppSharedPreferences.getInstance(requireContext())

        bind.email.setText(preferences.emailId)
        bind.mobile.setText(preferences.phoneNo)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.next -> {
                if (mUtil.isValidText(bind.email.text.toString().trim(), bind.email) &&
                    mUtil.isValidText(bind.mobile.text.toString().trim(), bind.mobile)
                ) {
                    (activity as MainActivity).showLoader()
                    CoroutineScope(Dispatchers.Main).launch {
                        val response = viewModel.addCompany(
                            preferences.userId,
                            bind.mobile.text.toString().trim(),
                            bind.email.text.toString().trim(),
                            mNull(args.companyName.toString()),
                            showDeviceInfo(requireContext()).toString(),
                            mNull(args.gstin.toString()),
                            mNull(args.address.toString()),
                            args.compositonType.toString(),
                            mNull(args.pincode.toString()),
                            " ",
                            " ",
                            " ",
                            " ",
                            " ",
                            if (args.image.isNullOrEmpty()) {
                                ""
                            } else {
                                args.image.toString()
                            },
                            if (args.image.isNullOrEmpty()) {
                                "0"
                            } else {
                                "1"
                            },
                            args.bussiness,
                            args.typeOnEntity,
                        )

                        if (response.data?.errorCode.equals("0")) {
                            preferences.companyId = response.data?.companyId
                            preferences.companyName = response.data?.companyName
                            val logo = response.data?.companyLogo
                            if (!TextUtils.isEmpty(logo)) preferences.companyImage = logo
                            preferences.companyGstin = response.data?.companyGstin
                            preferences.emailId = response.data?.email
                            preferences.phoneNo = response.data?.mobile
                            if (response.data?.compostionValue.equals("0")) {
                                preferences.companyCompositionValue = true
                            }
                            setNewProfileAsDefault(response.data)
                            (activity as MainActivity).hideLoader()
                            val intent = Intent(requireContext(), MainActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        } else {
                            (activity as MainActivity).hideLoader()
                            mUtil.mToast(requireContext(), response.data?.errorMsg.toString())
                        }
                    }

                }
            }
            R.id.previous -> {
                v.findNavController().navigateUp()
            }
        }
    }

    /* override fun onSuccess(type: String?, data: Any?) {
         if (type == "add_company") {
             progressDialog?.dismiss()
             val response = data as Response<CreateProfileRes>
             if (response.isSuccessful) {
                 val res = response.body()
                 if (response.body()!!.errorCode == "0") {


                     if (TextUtils.isEmpty(preferences.companyId)) {
                         preferences.companyId = res!!.companyId
                         preferences.companyName = res.companyName
                         val logo = res.companyLogo
                         Log.d("profilevalidation", "onSuccess: $logo")
                         if (!TextUtils.isEmpty(logo)) preferences.companyImage = logo
                         preferences.companyGstin = res.companyGstin
                         preferences.emailId = res.email
                         preferences.phoneNo = res.mobile
                         preferences.companyCompositionValue = res.compostionValue

 ////                        preferences.setCompanySupplyCode(res.get);
                     }
                     setNewProfileAsDefault(res!!)

                     val intent = Intent(requireContext(), DashboardActivity::class.java)
                     intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                     intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                     intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                     startActivity(intent)
                 }
                 mToast(requireContext(), res!!.errorMsg)
                 //onBackPressed()
             }
         } else if (type == "get_company") {
             progressDialog?.dismiss()
             val response = data as Response<GetCompanyRes>
             if (response.isSuccessful) {
                 if (response.body()!!.errorCode == "0") {

                 }
             }
         }
     }*/
    private fun setNewProfileAsDefault(res: CreateProfileRes?) {
        preferences.companyId = res?.companyId
        preferences.companyName = res?.companyName
        val logo = res?.companyLogo
        // if (!TextUtils.isEmpty(logo))
        preferences.companyImage = logo
        preferences.companyGstin = res?.companyGstin
        //UpdateSettings(requireContext())
    }
    /*override fun onFailure(errorMg: String?) {
        progressDialog?.hide()
        mToast(requireContext(), errorMg.toString())
        System.out.println(errorMg)
        Log.i("SANJAY ", "onFailure: " + errorMg)
    }*/

    fun mNull(value: String): String {
        return if (value != null) {
            value
        } else {
            " "
        }
    }


}