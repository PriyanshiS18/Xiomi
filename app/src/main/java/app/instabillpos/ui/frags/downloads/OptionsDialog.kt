package app.instabillpos.ui.frags.downloads

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import app.instabillpos.R
import app.instabillpos.databinding.OptionsDialogBinding
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import app.instabillpos.utils.Helper
import app.instabillpos.utils.Helper.*
import app.instabillpos.utils.PermissionUtil
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*


class OptionsDialog(private val flag: String) :
    DialogFragment(),
    View.OnClickListener {

    private var _binding: OptionsDialogBinding? = null
    private val bind get() = _binding!!

    var startDate = ""
    var endDate = ""
    private lateinit var sharedPreferences: AppSharedPreferences
    private var openDownloader: Boolean = true

    var excelUrl = ""
    var pdfUrl = ""
    var fileName = ""

    interface OptionsDialogListner {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OptionsDialogBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()


    }

    private fun setLinkAsPerAppropriateFlag() {
        when (flag) {
            "saleByCustomer" -> {
                excelUrl =
                    "download_excel_sales_customer/${sharedPreferences.userId}/${sharedPreferences.companyId}/${startDate}/${endDate}"
                pdfUrl =
                    "dowmload_sales_customer/${sharedPreferences.userId}/${sharedPreferences.companyId}/${startDate}/${endDate}"
                fileName = "SaleByCustomer${sharedPreferences.companyId}${startDate}${endDate}"
            }
            "saleByProduct" -> {
                excelUrl =
                    "download_excel_sales_product/${sharedPreferences.userId}/${sharedPreferences.companyId}/${startDate}/${endDate}"
                pdfUrl =
                    "download_sales_product/${sharedPreferences.userId}/${sharedPreferences.companyId}/${startDate}/${endDate}"
                fileName =
                    "download_sales_product${sharedPreferences.companyId}${startDate}${endDate}"
            }
            "invoiceReport" -> {
                excelUrl =
                    "invoice_report_excel/${sharedPreferences.userId}/${sharedPreferences.companyId}/${startDate}/${endDate}"
                pdfUrl =
                    "invoice_report_pdf/${sharedPreferences.userId}/${sharedPreferences.companyId}/${startDate}/${endDate}"
                fileName = "invoiceReport${sharedPreferences.companyId}${startDate}${endDate}"
            }
            "tvGstOne" -> {
                excelUrl = "gstr1_excel/${encodeString(sharedPreferences.userId)}/${
                    encodeString(sharedPreferences.companyId)
                }/${encodeString(startDate)}/${encodeString(endDate)}"
                pdfUrl = "gstr1/${encodeString(sharedPreferences.userId)}/${
                    encodeString(sharedPreferences.companyId)
                }/${encodeString(startDate)}/${encodeString(endDate)}"
                fileName = "gstr1${sharedPreferences.companyId}${startDate}${endDate}"
            }
            "tvGstThree" -> {
                excelUrl = "gstr3b_excel/${encodeString(sharedPreferences.userId)}/${
                    encodeString(sharedPreferences.companyId)
                }/${encodeString(startDate)}/${encodeString(endDate)}"
                pdfUrl = "gstr3b/${encodeString(sharedPreferences.userId)}/${
                    encodeString(sharedPreferences.companyId)
                }/${encodeString(startDate)}/${encodeString(endDate)}"
                fileName = "gstr3b${sharedPreferences.companyId}${startDate}${endDate}"
            }
            "tvGst8" -> {
                excelUrl = "gstr4_excel/${encodeString(sharedPreferences.userId)}/${
                    encodeString(sharedPreferences.companyId)
                }/${encodeString(startDate)}/${encodeString(endDate)}"
                pdfUrl = "gstr4/${encodeString(sharedPreferences.userId)}/${
                    encodeString(sharedPreferences.companyId)
                }/${encodeString(startDate)}/${encodeString(endDate)}"
                fileName = "gstr4${sharedPreferences.companyId}${startDate}${endDate}"
            }
        }

    }

    private fun initAllComponents() {
        bind.close.setOnClickListener(this)
        bind.lastMonth.setOnClickListener(this)
        bind.thisMonth.setOnClickListener(this)
        bind.custom.setOnClickListener(this)
        sharedPreferences = AppSharedPreferences.getInstance(requireContext())
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (openDownloader) {
            if (!PermissionUtil.verifyPermissions(
                    requireContext(), PermissionUtil.getGalleryPermissions()
                )
            ) {
                requestPermissions(
                    arrayOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ),
                    100
                )
            } else {
                setLinkAsPerAppropriateFlag()
                openDownloaderBottomSheet()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            for (i in permissions.indices) {
                val permission = permissions[i]
                val grantResult = grantResults[i]
                if (permission == Manifest.permission.READ_EXTERNAL_STORAGE) {
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        openDownloaderBottomSheet()
                    }
                }
            }
        }
    }

    private fun openDownloaderBottomSheet() {
        val export = ExportFile(
            pdfUrl,
            excelUrl,
            fileName
        )
        /* val export = ExportFile(
            "gst_tax_pdf_download/" + sharedPreferences.userId + "/" + sharedPreferences.companyId + "/" + startDate + "/" + endDate,
            "gst_tax_excel_download/" + sharedPreferences.userId + "/" + sharedPreferences.companyId + "/" + startDate + "/" + endDate,
            "gst_tax $startDate $endDate"
        )*/
        export.showNow(parentFragmentManager, "SANJAY")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.close -> {
                openDownloader = false
                dismiss()
            }
            R.id.lastMonth -> {
                startDate = getLastMonthStartEndDate()[0]
                endDate = getLastMonthStartEndDate()[1]
                dismiss()
            }
            R.id.thisMonth -> {
                startDate = getCurrentMonthStartEndDate()[0]
                endDate = getCurrentMonthStartEndDate()[1]
                dismiss()
            }
            R.id.custom -> {

                val dateRangePicker =
                    MaterialDatePicker.Builder.dateRangePicker()
                        .setTitleText("Select dates")
                        .build()
                dateRangePicker.show(parentFragmentManager, "")

                dateRangePicker.addOnNegativeButtonClickListener { dateRangePicker.dismiss() }
                dateRangePicker.addOnPositiveButtonClickListener {
                    val timeZoneUTC = TimeZone.getDefault()
                    val offsetFromUTC = timeZoneUTC.getOffset(Date().time) * -1
                    val simpleFormat = SimpleDateFormat("dd-MM-yyyy", Locale.US)
                    val startDatee = Date(dateRangePicker.selection?.first?.plus(offsetFromUTC)!!)
                    val endDatee = Date(dateRangePicker.selection?.second?.plus(offsetFromUTC)!!)

                    startDate = Helper.formatDate(simpleFormat.format(startDatee))
                    endDate = Helper.formatDate(simpleFormat.format(endDatee))
                    dismiss()

                }
            }
        }
    }
}