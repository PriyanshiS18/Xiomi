package app.instabillpos.mProguard.Model


import com.google.gson.annotations.SerializedName

data class InvoiceNumberModel(
    @SerializedName("data")
    var `data`: String,
    @SerializedName("errorCode")
    var errorCode: String,
    @SerializedName("errorMsg")
    var errorMsg: String
)