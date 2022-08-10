package app.instabillpos.ui.frags.downloads

import android.app.ProgressDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import app.instabillpos.R
import app.instabillpos.databinding.ExportFileBinding
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import app.instabillpos.utils.Helper.BaseUrl
import app.instabillpos.utils.Helper.timeOutTime
import app.instabillpos.utils.mUtil.mLog
import app.instabillpos.utils.mUtil.mToast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit


class ExportFile(
    private val pdfUrl: String,
    private val excelUrl: String,
    private val filename: String,
) :
    BottomSheetDialogFragment(), View.OnClickListener {


    private var pDialog: ProgressDialog? = null
    private var _binding: ExportFileBinding? = null
    private val bind get() = _binding!!
    private var urlMain: String = ""
    var file = File(Environment.getExternalStorageDirectory().absolutePath)
    var pdfFlag: Boolean = false
    var excelFlag: Boolean = false
    private lateinit var sharedPreferences: AppSharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ExportFileBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
    }

    private fun initAllComponents() {
        bind.open.setOnClickListener(this)
        bind.dismiss.setOnClickListener(this)
        bind.excel.setOnClickListener(this)
        bind.pdf.setOnClickListener(this)

        sharedPreferences = AppSharedPreferences.getInstance(requireContext())

        if (pdfUrl.isNotEmpty())
            bind.pdf.visibility = View.VISIBLE
        if (excelUrl.isNotEmpty())
            bind.excel.visibility = View.VISIBLE

        if (excelUrl.isEmpty() && pdfUrl.isNotEmpty())
            bind.pdf.performClick()

        if (excelUrl.isNotEmpty() && pdfUrl.isEmpty())
            bind.excel.performClick()


        mLog("Excel :: $excelUrl :: PDF :: $pdfUrl")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.open -> {
                dismiss()
                try {
                    val fileURI = FileProvider.getUriForFile(
                        requireContext(),
                        "app.instabillpos.provider.MyProvider",
                        file.absoluteFile
                    )

                    val intent = Intent(Intent.ACTION_VIEW)
                    if (pdfFlag) {
                        intent.setDataAndType(fileURI, "application/pdf")
                    }

                    if (excelFlag) {
                        intent.setDataAndType(fileURI, "application/vnd.ms-excel");
                    }
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION


                    try {
                        startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        val toss = if (pdfFlag) {
                            "to view pdf"
                        } else if (excelFlag) {
                            "to view excel"
                        } else {
                            ""
                        }
                        Toast.makeText(
                            requireContext(),
                            "No Application Available $toss",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    mLog("FILE :: $file")
                    mLog("URI :: $fileURI")

                } catch (e: Exception) {
                    mLog("Crash has been registered" + e.localizedMessage)
                }
            }

            R.id.dismiss -> {
                dismiss()
            }
            R.id.iv_b_close -> {
                dismiss()
            }
            R.id.pdf -> {
                CoroutineScope(Dispatchers.IO).launch {
                    pdfFlag = true
                    excelFlag = false
                    hitApi(pdfUrl, ".pdf")
                }
            }
            R.id.excel -> {
                if (sharedPreferences.planType == "Enterprise") {
                    pdfFlag = false
                    excelFlag = true
                    CoroutineScope(Dispatchers.IO).launch {
                        hitApi(excelUrl, ".xlsx")
                    }
                } else {
                    mToast(
                        requireContext(),
                        "Excel format download not available in the current plan, Upgrade your plan."
                    )
                }

            }
        }
    }

    private fun hitApi(url: String, extension: String) {
        CoroutineScope(Dispatchers.Main).launch {
            bind.ui.visibility = View.GONE
            bind.loader.visibility = View.VISIBLE
        }
        urlMain = "$BaseUrl$url"

        mLog(urlMain)
        file =
            File(Environment.getExternalStorageDirectory().absolutePath + "/InstaBill downloads/" + filename + extension)
        var okHttpClient = OkHttpClient()
        val okHttpBuilder = okHttpClient.newBuilder()
            .connectTimeout(timeOutTime, TimeUnit.SECONDS)
            .readTimeout(timeOutTime, TimeUnit.SECONDS)
        okHttpClient = okHttpBuilder.build()
        val request = Request.Builder().url(urlMain).build()
        val response = okHttpClient.newCall(request).execute()

        val body = response.body
        val responseCode = response.code
        if (responseCode >= HttpURLConnection.HTTP_OK &&
            responseCode < HttpURLConnection.HTTP_MULT_CHOICE &&
            body != null
        ) {
            try {
                body.byteStream().apply {
                    file.outputStream().use { fileOut ->
                        copyTo(fileOut, 8192)
                    }
                }
            } catch (e: Exception) {
                file =
                    File(Environment.getExternalStorageDirectory().absolutePath + "/Android/data/" + requireContext().packageName + "/" + filename + extension)
                body.byteStream().apply {
                    file.outputStream().use { fileOut ->
                        copyTo(fileOut, 8192)
                    }
                }
            }

            CoroutineScope(Dispatchers.Main).launch {
                bind.loader.visibility = View.GONE
                bind.openFile.visibility = View.VISIBLE
                bind.open.performClick()
            }

        } else {

            CoroutineScope(Dispatchers.Main).launch {
                bind.ui.visibility = View.VISIBLE
                bind.loader.visibility = View.GONE
                mToast(requireContext(), "Error downloading " + response.message)
            }
        }
    }
}