package app.instabillpos.ui.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import app.instabillpos.R
import app.instabillpos.databinding.SettingBinding
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Setting : Fragment(),
    View.OnClickListener {

    private var _binding: SettingBinding? = null
    private val bind get() = _binding!!
    var sharedPref: AppSharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SettingBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAllComponents()

        setTaxType()
        setCess()
        setComposition()
    }

    private fun setComposition() {
        if (sharedPref!!.companyCompositionValue) {
            bind.compositionONN.setBackgroundColor(resources.getColor(R.color.grad_color_2))
            bind.compositionONN.setTextColor(resources.getColor(R.color.white))

            bind.compositionOFF.setBackgroundColor(resources.getColor(R.color.white))
            bind.compositionOFF.setTextColor(resources.getColor(R.color.black))
        } else {
            bind.compositionOFF.setBackgroundColor(resources.getColor(R.color.grad_color_2))
            bind.compositionOFF.setTextColor(resources.getColor(R.color.white))

            bind.compositionONN.setBackgroundColor(resources.getColor(R.color.white))
            bind.compositionONN.setTextColor(resources.getColor(R.color.black))
        }
    }

    private fun setCess() {
        if (sharedPref!!.isCessActive) {
            bind.cessONN.setBackgroundColor(resources.getColor(R.color.grad_color_2))
            bind.cessONN.setTextColor(resources.getColor(R.color.white))

            bind.cessOFF.setBackgroundColor(resources.getColor(R.color.white))
            bind.cessOFF.setTextColor(resources.getColor(R.color.black))
        } else {
            bind.cessOFF.setBackgroundColor(resources.getColor(R.color.grad_color_2))
            bind.cessOFF.setTextColor(resources.getColor(R.color.white))

            bind.cessONN.setBackgroundColor(resources.getColor(R.color.white))
            bind.cessONN.setTextColor(resources.getColor(R.color.black))
        }
    }

    private fun setTaxType() {
        if (sharedPref!!.isInclusive) {
            setInclusive()
        } else {
            setExclusive()
        }
    }


    private fun initAllComponents() {
        sharedPref = AppSharedPreferences.getInstance(requireContext())

        bind.inclusive.setOnClickListener(this)
        bind.exclusive.setOnClickListener(this)

        bind.cessOFF.setOnClickListener(this)
        bind.cessONN.setOnClickListener(this)

        bind.compositionOFF.setOnClickListener(this)
        bind.compositionONN.setOnClickListener(this)

        bind.back.setOnClickListener(this)

    }

    private fun setExclusive() {
        bind.exclusive.setBackgroundColor(resources.getColor(R.color.grad_color_2))
        bind.exclusive.setTextColor(resources.getColor(R.color.white))

        bind.inclusive.setBackgroundColor(resources.getColor(R.color.white))
        bind.inclusive.setTextColor(resources.getColor(R.color.black))
    }

    private fun setInclusive() {
        bind.inclusive.setBackgroundColor(resources.getColor(R.color.grad_color_2))
        bind.inclusive.setTextColor(resources.getColor(R.color.white))

        bind.exclusive.setBackgroundColor(resources.getColor(R.color.white))
        bind.exclusive.setTextColor(resources.getColor(R.color.black))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.inclusive -> {
                //false means exclusive
                // true means inclusive
                sharedPref?.isInclusive = false
                setTaxType()

            }
            R.id.exclusive -> {
                sharedPref?.isInclusive = true
                setTaxType()
            }
            R.id.compositionOFF -> {
                sharedPref?.companyCompositionValue = false
                setComposition()
            }
            R.id.compositionONN -> {
                sharedPref?.companyCompositionValue = true
                setComposition()
            }
            R.id.cessOFF -> {
                sharedPref?.setCess(false)
                setCess()
            }
            R.id.cessONN -> {
                sharedPref?.setCess(true)
                setCess()
            }
            R.id.back -> {
                requireView().findNavController().popBackStack()
            }
        }
    }


}