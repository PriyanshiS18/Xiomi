package app.instabillpos.ui.frags

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import app.instabillpos.R
import app.instabillpos.databinding.SplahScreenBinding
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplahScreen : Fragment() {

    private var _binding: SplahScreenBinding? = null
    private val bind get() = _binding!!
    private lateinit var sharedPreferences: AppSharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SplahScreenBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
    }

    private fun initAllComponents() {
        sharedPreferences = AppSharedPreferences.getInstance(requireContext())
        Handler(Looper.getMainLooper()).postDelayed({
            if (sharedPreferences.isLogin) {
                if (sharedPreferences.companyId.isEmpty()) {
                    view?.findNavController()?.navigate(R.id.splahScreen_to_bussinessType)
                } else {
                    view?.findNavController()?.navigate(R.id.splahScreen_to_dashboard)
                }
            } else {
                view?.findNavController()?.navigate(R.id.splahScreen_to_loginScreen)
            }

        }, 3000)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun onDetach() {
        super.onDetach()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

}