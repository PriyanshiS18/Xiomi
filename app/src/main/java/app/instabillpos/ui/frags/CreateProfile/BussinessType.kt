package app.instabillpos.ui.frags.CreateProfile

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import app.instabillpos.R
import app.instabillpos.databinding.BussinessTypeBinding


class BussinessType : Fragment(), View.OnClickListener {

    private var _binding: BussinessTypeBinding? = null
    private val bind get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BussinessTypeBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        InitAllComponents()
    }

    private fun InitAllComponents() {
        navController =
            Navigation.findNavController(context as Activity, R.id.fragmentContainerView)
        bind.manufacture.setOnClickListener(this)
        bind.wholesaller.setOnClickListener(this)
        bind.retailer.setOnClickListener(this)
        bind.pharma.setOnClickListener(this)
        bind.traveller.setOnClickListener(this)
        bind.serviceProvider.setOnClickListener(this)
        bind.other.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.manufacture -> {
                val action = BussinessTypeDirections.bussinessTypeToCompanyLogo("Manufacture")
                v.findNavController().navigate(action)
                //navController.navigate(R.id.bussinessType_to_companyLogo)
            }
            R.id.serviceProvider -> {
                val action = BussinessTypeDirections.bussinessTypeToCompanyLogo("Service Provider")
                v.findNavController().navigate(action)
            }
            R.id.pharma -> {
                val action = BussinessTypeDirections.bussinessTypeToCompanyLogo("Pharma / Chemist")
                v.findNavController().navigate(action)
            }
            R.id.other -> {
                val action = BussinessTypeDirections.bussinessTypeToCompanyLogo("Others")
                v.findNavController().navigate(action)
            }
            R.id.wholesaller -> {
                val action = BussinessTypeDirections.bussinessTypeToCompanyLogo("Wholeseller")
                v.findNavController().navigate(action)
            }
            R.id.retailer -> {
                val action = BussinessTypeDirections.bussinessTypeToCompanyLogo("Trader / Retailer")
                v.findNavController().navigate(action)
            }

            R.id.traveller -> {
                val action = BussinessTypeDirections.bussinessTypeToCompanyLogo("Travelling Agency")
                v.findNavController().navigate(action)
            }
        }
    }
}