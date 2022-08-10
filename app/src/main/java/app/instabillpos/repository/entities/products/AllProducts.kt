package app.instabillpos.repository.entities.products


import com.google.gson.annotations.SerializedName

data class AllProducts(
    @SerializedName("data")
    var data: List<Data>,
    @SerializedName("errorCode")
    var errorCode: String,
    @SerializedName("errorMsg")
    var errorMsg: String
)