package app.instabillpos.ui.frags.Reports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import app.instabillpos.R
import app.instabillpos.databinding.ReportsBinding
import app.instabillpos.ui.frags.downloads.OptionsDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Reports : Fragment(), View.OnClickListener, OptionsDialog.OptionsDialogListner {

    private var _binding: ReportsBinding? = null
    private val bind get() = _binding!!

    private val viewModel: ReportsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ReportsBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
    }

    private fun initAllComponents() {
        //bind.salesReport.setOnClickListener(this)
        //bind.gstReport.setOnClickListener(this)
        bind.tvSaleByCustomer.setOnClickListener(this)
        bind.tvSaleByProduct.setOnClickListener(this)
        bind.invoiceReport.setOnClickListener(this)
        bind.tvGstOne.setOnClickListener(this)
        bind.tvGstThree.setOnClickListener(this)
        bind.tvGst8.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.salesReport -> {
                if (bind.salesReportContainer.visibility == VISIBLE) {
                    bind.salesReportContainer.visibility = GONE
                    bind.salesReport.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_keyboard_arrow,
                        0
                    )
                } else {
                    bind.salesReportContainer.visibility = VISIBLE
                    bind.salesReport.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_keyboard_arrow_up_white,
                        0
                    )
                }

                if (bind.gstReportContainer.visibility == VISIBLE) {
                    bind.gstReportContainer.visibility = GONE
                    bind.gstReport.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_keyboard_arrow,
                        0
                    )
                }

            }
            R.id.gstReport -> {
                if (bind.gstReportContainer.visibility == VISIBLE) {
                    bind.gstReportContainer.visibility = GONE
                    bind.gstReport.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_keyboard_arrow,
                        0
                    )
                } else {
                    bind.gstReportContainer.visibility = VISIBLE
                    bind.gstReport.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_keyboard_arrow_up_white,
                        0
                    )
                }

                if (bind.salesReportContainer.visibility == VISIBLE) {
                    bind.salesReportContainer.visibility = GONE
                    bind.salesReport.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_keyboard_arrow,
                        0
                    )
                }
            }
            R.id.tv_sale_by_customer -> {
                val succesDialog = OptionsDialog("saleByCustomer")
                succesDialog.showNow(parentFragmentManager, "SANJAY")
            }
            R.id.tv_sale_by_product -> {
                val succesDialog = OptionsDialog("saleByProduct")
                succesDialog.showNow(parentFragmentManager, "SANJAY")
            }
            R.id.invoiceReport -> {
                val succesDialog = OptionsDialog("invoiceReport")
                succesDialog.showNow(parentFragmentManager, "SANJAY")
            }
            R.id.tv_gst_one -> {
                val succesDialog = OptionsDialog("tvGstOne")
                succesDialog.showNow(parentFragmentManager, "SANJAY")
            }
            R.id.tv_gst_three -> {
                val succesDialog = OptionsDialog("tvGstThree")
                succesDialog.showNow(parentFragmentManager, "SANJAY")
            }
            R.id.tv_gst_8 -> {
                val succesDialog = OptionsDialog("tvGst8")
                succesDialog.showNow(parentFragmentManager, "SANJAY")
            }
        }
    }


}