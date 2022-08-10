package app.instabillpos.ui.frags.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import app.instabillpos.BuildConfig
import app.instabillpos.R
import app.instabillpos.databinding.SignUpScreenBinding
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import app.instabillpos.ui.activity.MainActivity.MainActivity
import app.instabillpos.utils.mUtil.isValidEmail
import app.instabillpos.utils.mUtil.isValidText
import app.instabillpos.utils.mUtil.mLog
import app.instabillpos.utils.mUtil.mToast
import app.instabillpos.utils.mUtil.showDeviceInfo
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpScreen : Fragment(), View.OnClickListener {

    private var _binding: SignUpScreenBinding? = null
    private val bind get() = _binding!!
    private val viewModel: SignUpViewModel by viewModels()
    private lateinit var sharedPreferences: AppSharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SignUpScreenBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
    }

    private fun initAllComponents() {
        bind.signIN.setOnClickListener(this)
        bind.signUp.setOnClickListener(this)
        sharedPreferences = AppSharedPreferences.getInstance(requireContext())


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signIN -> {
                v.findNavController().navigate(R.id.signUpScreen_to_loginScreen)


            }
            R.id.signUp -> {
                //v.findNavController().navigate(R.id.signUpScreen_to_bussinessType)
                if (bind.terms.isChecked) {
                    if (isValidText(bind.name.text.toString().trim(), bind.name) &&
                        isValidText(bind.mobile.text.toString().trim(), bind.mobile) &&
                        isValidEmail(bind.email.text.toString().trim(), bind.email) &&
                        isValidText(bind.password.text.toString().trim(), bind.password)
                    ) {

                        if (bind.password.text.toString()
                                .trim() == bind.confirmPassword.text.toString().trim()
                        ) {
                            (activity as MainActivity).showLoader()
                            CoroutineScope(Dispatchers.Main).launch {
                                val response = viewModel.register(
                                    bind.name.text.toString().trim(),
                                    bind.mobile.text.toString().trim(),
                                    bind.password.text.toString().trim(),
                                    bind.email.text.toString().trim(),
                                    showDeviceInfo(requireContext()).toString()
                                )
                                //mLog(Gson().toJson(response))
                                if (response.data?.errorCode.equals("0")) {
                                    (activity as MainActivity).hideLoader()
                                    val preferences = sharedPreferences
                                    val data= response.data!!.data[0]
                                    preferences.isLogin = true
                                    preferences.name = data.name
                                    preferences.emailId = data.email
                                    preferences.setParentuser(data.userId)
                                    preferences.userId = data.userId
                                    preferences.phoneNo = data.phone
                                    preferences.expiryDate = data.expireDate

                                    preferences.companyGstin = data.companyGstin
                                    preferences.companyId = data.companyId
                                    preferences.companyImage = data.companyLogo
                                    preferences.companyName = data.companyName

                                    preferences.address = data.companyAddress
                                    preferences.setLoginTime(data.loginTime)
                                    preferences.packagePlan = data.packagePlan

                                    preferences.userInstaId = "INSTA0" + preferences.userId
                                    if (data.inventoryStatus.equals("1") && "Enterprise" == preferences.planType
                                    ) {
                                        preferences.setInventoryStatus(true)
                                    } else {
                                        preferences.setInventoryStatus(false)
                                    }
                                    v.findNavController().navigate(R.id.signUpScreen_to_bussinessType)

                            }else{
                                (activity as MainActivity).hideLoader()
                                mToast(requireContext(), response.data?.errorMsg.toString())
                            }
                        }

                    } else {
                        mToast(requireContext(), "Password doesn't match")
                    }
                }

            }
            else {
                mToast(requireContext(), "Please accept terms & conditions")
            }
        }
    }

}

}