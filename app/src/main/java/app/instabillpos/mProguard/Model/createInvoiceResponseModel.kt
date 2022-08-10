package app.instabillpos.mProguard.Model


import com.google.gson.annotations.SerializedName

data class createInvoiceResponseModel(
    @SerializedName("errorCode")
    var errorCode: String,
    @SerializedName("errorMsg")
    var errorMsg: String
)