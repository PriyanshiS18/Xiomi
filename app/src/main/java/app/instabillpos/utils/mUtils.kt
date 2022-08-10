package app.instabillpos.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.os.Environment
import android.provider.Settings
import android.text.TextUtils
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import app.instabillpos.repository.entities.products.Data
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


object mUtil {


    fun saveBitMap(context: Context, Final_bitmap: Bitmap): File? {
        val pictureFileDir = File(
            Environment.getExternalStorageDirectory()
                .toString() + "/Android/data/" + context.packageName
        )
        if (!pictureFileDir.exists()) {
            val isDirectoryCreated = pictureFileDir.mkdirs()
            if (!isDirectoryCreated) Log.i("SANJAY ", "Can’t create directory to save the image")
            return null
        }
        val filename = pictureFileDir.path + File.separator + System.currentTimeMillis() + ".jpg"
        val pictureFile = File(filename)
        try {
            pictureFile.createNewFile()
            val oStream = FileOutputStream(pictureFile)
            Final_bitmap.compress(Bitmap.CompressFormat.PNG, 18, oStream)
            oStream.flush()
            oStream.close()
            Log.i("SANJAY ", "llsaveBitMap :: Save Image Successfully..")
        } catch (e: IOException) {
            e.printStackTrace()
            Log.i("SANJAY", "There was an issue saving the image.")
            Log.i("SANJAY", "Error :: " + e.localizedMessage)
        }
        return pictureFile
    }

    fun mToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun isValidText(text: String?, editText: EditText): Boolean {
        if (TextUtils.isEmpty(text)) {
            editText.requestFocus()
            editText.error = "Mandatory"

            return false
        }
        return true
    }

    fun isValidEmail(text: String, editText: EditText): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return if (text.isNotEmpty()) {
            if (text.matches(emailPattern.toRegex())) {
                true
            } else {
                editText.requestFocus()
                editText.error = "Invalid Email ID"
                false
            }
        } else {
            editText.requestFocus()
            editText.error = "Mandatory"
            false
        }
    }

    fun mLog(message: String) {
        Log.i("SANJAY", "mLog: $message")
    }

    fun String.decode(): String {
        return Base64.decode(this, Base64.DEFAULT).toString(charset("UTF-8"))
    }

    fun String.encode(): String {
        return Base64.encodeToString(this.toByteArray(charset("UTF-8")), Base64.DEFAULT)
    }


    //For Fragment
    fun Fragment.hideKeyboard() = ViewCompat.getWindowInsetsController(requireView())
        ?.hide(WindowInsetsCompat.Type.ime())

    fun hideKeyboard(context: Context, view: View) {
        val imm: InputMethodManager? =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showDeviceInfo(context: Context): String? {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    fun getPlanDuration(value: String): String? {
        var planDuration = "Trial"
        if (value == "1") {
            planDuration = "Monthly"
        } else if (value == "2") {
            planDuration = "Yearly"
        }
        return planDuration
    }

    fun formatDoubleToTwoDecimals(value: Double): Double {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.FLOOR
        return df.format(value).toDouble()
    }


    /*In case of Exclusive Tax
GST = Product Tax Rate % X (Product Total Amount - Discount)

In case of Inclusive Tax
GST = Product Tax Rate X (Product Total Amount - Discount)
           —---------------------------------------------------------------------
                              (100 + Product Tax Rate)
*/
    fun funCalculateGst(product: ArrayList<Data>, exclusiveOrInclusiveFlag: Boolean): Double {
        //True means tax is exclusive
        //False means tax is inclusive
        val discount: Double = 0.0
        var amount: Double = 0.0
        for (i in product.indices) {
            mLog("Tax Rate" + product[i].taxRate.toString())
            mLog("Product Rate" + product[i].productRate.toString())
            mLog("Quantity" + product[i].productType)
            mLog("Discount" + "0")
            if (exclusiveOrInclusiveFlag) {
                amount +=
                    ((product[i].taxRate!!.toDouble() / 100) * (product[i].productRate!!.toDouble() - discount)) * product[i].productType!!.toDouble()
            } else {
                amount +=
                    ((product[i].taxRate!!.toDouble() / (100 + product[i].taxRate!!.toDouble())) * (product[i].productRate!!.toDouble() - discount)) * product[i].productType!!.toDouble()
            }
        }
        return formatDoubleToTwoDecimals(amount)
    }

    fun getFinalDateValidUptoSend(validuptodate: String): String {
        val mFormat = DecimalFormat("00")
        val datee = validuptodate.split("/").toTypedArray()
        val day = datee[0].toInt()
        val month = datee[1].toInt()
        val year = datee[2].toInt()
        return year.toString() + "-" + mFormat.format(month.toLong()) + "-" + mFormat.format(day.toLong())
    }


    fun todayDate(): String? {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val date = Date()
        return formatter.format(date)
    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val ni = connectivityManager.activeNetworkInfo
        return ni != null && ni.isAvailable && ni.isConnected
    }
}