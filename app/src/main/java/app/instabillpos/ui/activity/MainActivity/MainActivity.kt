package app.instabillpos.ui.activity.MainActivity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import app.instabillpos.databinding.ActivityMainBinding
import app.instabillpos.mProguard.Model.CreateOrderr
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import app.instabillpos.repository.utils.Resource
import app.instabillpos.utils.mUtil.isOnline
import app.instabillpos.utils.mUtil.mLog
import app.instabillpos.utils.mUtil.mToast
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bind: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var sharedPreferences: AppSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        intiAllComponents()
        if (sharedPreferences.isLogin) {
            setupObservers()

        }
        CoroutineScope(Dispatchers.Main).launch {
            setUpOfflineInvoiceObserver()
        }

    }

    private suspend fun setUpOfflineInvoiceObserver() {
        viewModel.invoice.observeForever {
            for (i in it.indices) {
                if (isOnline(this@MainActivity)) {
                    CoroutineScope(Dispatchers.IO).launch {

                        async {
                            sendDataToServer(it[i])
                        }.await()


                    }

                }

            }

        }
    }

    private suspend fun sendDataToServer(createOrder: CreateOrderr) {
        if (createOrder.invoiceId.isNullOrEmpty()) {

            val invoiceNumber = viewModel.getInvoiceNumber()

            if (invoiceNumber.data?.errorCode.equals("0")) {
                mLog(invoiceNumber.data?.data.toString())
                val finalInvoiceNumber = "INSTAA" + invoiceNumber.data?.data

                createOrder.invoiceId = finalInvoiceNumber
                createOrder.invoiceCount = invoiceNumber.data?.data


                mLog("-----------------------------------------------------------------------")
                mLog("Invoice ID :: " + finalInvoiceNumber + " :: " + invoiceNumber.data?.data)
                mLog("RAW " + Gson().toJson(createOrder))
                mLog("-----------------------------------------------------------------------")


                withContext(Dispatchers.Default) {
                    val sendInvoiceToServer = viewModel.createInvoice(createOrder)
                    if (sendInvoiceToServer.data?.errorCode.equals("0")) {
                        bind.progressBar.visibility = GONE
                        deleteEntryFromOfflineDatabase(createOrder)
                        mLog("Sending offline data to online")
                    } else {
                        bind.progressBar.visibility = GONE
                        sendInvoiceToServer.data?.let { it ->
                            withContext(Dispatchers.Main) {
                                mLog(it.errorMsg)
                                mToast(
                                    this@MainActivity,
                                    it.errorMsg
                                )
                            }
                        }
                    }
                }

            }
        } else {
            withContext(Dispatchers.Default) {
                mLog("Raw :: EDIT API :: " + Gson().toJson(createOrder))
                val sendInvoiceToServer = viewModel.editInvoice(createOrder)
                if (sendInvoiceToServer.data?.errorCode.equals("0")) {
                    bind.progressBar.visibility = GONE
                    deleteEntryFromOfflineDatabase(createOrder)
                } else {
                    bind.progressBar.visibility = GONE
                    sendInvoiceToServer.data?.let { it ->
                        withContext(Dispatchers.Main) {
                            mLog(it.errorMsg)
                            mToast(
                                this@MainActivity,
                                it.errorMsg
                            )
                        }
                    }
                }
            }
        }
    }

    private fun deleteEntryFromOfflineDatabase(offlineInvoiceID: CreateOrderr) {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.deleteEntryFromOfflineDatabase(offlineInvoiceID)
        }
    }

    private fun setupObservers() {
        viewModel.products.observeForever {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bind.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) {
                        //adapter.setItems(ArrayList(it.data))
                    }
                }
                Resource.Status.ERROR -> {
                    Log.i("SANJAY", "setupObservers: ERROR  ${it.message}")
                }

                Resource.Status.LOADING -> {
                    Log.i("SANJAY", "setupObservers: LOADING")
                    bind.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }


    private fun intiAllComponents() {
        sharedPreferences = AppSharedPreferences.getInstance(this)
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    public fun showLoader() {
        if (bind.progressBar.visibility == GONE) {
            bind.progressBar.visibility = VISIBLE
        }
    }

    public fun hideLoader() {
        if (bind.progressBar.visibility == VISIBLE) {
            bind.progressBar.visibility = GONE
        }
    }
}