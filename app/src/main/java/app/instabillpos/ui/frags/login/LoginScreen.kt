package app.instabillpos.ui.frags.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import app.instabillpos.R
import app.instabillpos.databinding.LoginScreenBinding
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import app.instabillpos.ui.activity.MainActivity.MainActivity
import app.instabillpos.utils.mUtil
import app.instabillpos.utils.mUtil.getPlanDuration
import app.instabillpos.utils.mUtil.isValidEmail
import app.instabillpos.utils.mUtil.isValidText
import app.instabillpos.utils.mUtil.mToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class LoginScreen : Fragment(), View.OnClickListener {

    private var _binding: LoginScreenBinding? = null
    private val bind get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var sharedPreferences: AppSharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginScreenBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
    }

    private fun initAllComponents() {
        bind.login.setOnClickListener(this)
        bind.signUp.setOnClickListener(this)
        sharedPreferences = AppSharedPreferences.getInstance(requireContext())
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login -> {
                if (isValidEmail(bind.email.text.toString().trim(), bind.email)
                    && isValidText(bind.password.text.toString().trim(), bind.password)
                ) {
                    (activity as MainActivity).showLoader()
                    CoroutineScope(Dispatchers.Main).launch {
                        val response = viewModel.loginUser(
                            bind.email.text.toString().trim(),
                            bind.password.text.toString().trim(),
                            mUtil.showDeviceInfo(requireContext()).toString()
                        )
                        if (response.data?.errorCode.equals("0")) {
                            sharedPreferences.isLogin = true
                            sharedPreferences.setParentuser(response.data?.data?.get(0)?.userId)
                            sharedPreferences.userId = response.data?.data?.get(0)?.userId
                            sharedPreferences.name = response.data?.data?.get(0)?.name
                            sharedPreferences.emailId = response.data?.data?.get(0)?.email
                            sharedPreferences.phoneNo = response.data?.data?.get(0)?.phone
                            sharedPreferences.expiryDate = response.data?.data?.get(0)?.expireDate
                            sharedPreferences.companyGstin =
                                response.data?.data?.get(0)?.companyGstin
                            sharedPreferences.companyId = response.data?.data?.get(0)?.companyId
                            sharedPreferences.companyImage =
                                response.data?.data?.get(0)?.companyLogo
                            sharedPreferences.companyName = response.data?.data?.get(0)?.companyName
                            if (response.data?.data?.get(0)?.gstCompositeScheme.equals("0")) {
                                sharedPreferences.companyCompositionValue = true
                            }
                            sharedPreferences.address = response.data?.data?.get(0)?.companyAddress
                            sharedPreferences.setLoginTime(response.data?.data?.get(0)?.loginTime)

                            sharedPreferences.packagePlan = response.data?.data?.get(0)?.packagePlan
                            sharedPreferences.planDuration =
                                getPlanDuration(response.data?.data?.get(0)?.packagePlan.toString())
                            (activity as MainActivity).hideLoader()
                            v.findNavController().navigate(R.id.loginScreen_to_dashboard)
                        } else {
                            (activity as MainActivity).hideLoader()
                            mToast(requireContext(), response.data?.errorMsg.toString())
                        }
                    }
                }
            }
            R.id.signUp -> {
                v.findNavController().navigate(R.id.loginScreen_to_signUpScreen)
            }
        }
    }

}