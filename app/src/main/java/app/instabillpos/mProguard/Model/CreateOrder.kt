package app.instabillpos.mProguard.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CreateOrder(

    @PrimaryKey
    @SerializedName("invoice_id")
    @Expose
    var invoiceId: String,
    @SerializedName("company_id")
    @Expose
    var company_id: String?,

    @SerializedName("userId")
    @Expose
    var userId: String?,

    @SerializedName("state")
    @Expose
    var state: String?,

    @SerializedName("change_amt")
    @Expose
    var change: String?,


    @SerializedName("variant")
    @Expose
    var variant: Int?,

    @SerializedName("quot_id")
    @Expose
    var quotId: String?,

    @SerializedName("date")
    @Expose
    var date: String?,

    @SerializedName("invoice_no")
    @Expose
    var invoiceNo: String?,

    @SerializedName("invoice_date")
    @Expose
    var invoiceDate: String?,

    @SerializedName("credit_note_date")
    @Expose
    var creditNoteDate: String?,

    @SerializedName("company_name")
    @Expose
    var companyName: String?,

    @SerializedName("address")
    @Expose
    var address: String?,

    @SerializedName("gstin")
    @Expose
    var gstin: String?,

    @SerializedName("place_supply")
    @Expose
    var placeOfSupply: String?,

    @SerializedName("tax_type")
    @Expose
    var taxType: String?,

    @SerializedName("due_terms")
    @Expose
    var dueTerm: String?,

    @SerializedName("supply_code")
    @Expose
    var supplyCode: String?,

    @SerializedName("sub_total")
    @Expose
    var subTotal: String?,

    @SerializedName("cgst")
    @Expose
    var cgst: String?,

    @SerializedName("sgst")
    @Expose
    var sgst: String?,

    @SerializedName("igst")
    @Expose
    var igst: String?,

    @SerializedName("cess_charge")
    @Expose
    var cessTotal: String?,

    @SerializedName("cess_amount")
    @Expose
    var cessAmount: String?,

    @SerializedName("shipping_charge")
    @Expose
    var shippingCharge: String?,

    @SerializedName("customer_email")
    @Expose
    var customerEmail: String?,

    @SerializedName("customer_id")
    @Expose
    var customerId: Int?,

    @SerializedName("total")
    @Expose
    var totalBalance: String?,

    @SerializedName("fotter")
    @Expose
    var footer: String?,

    @SerializedName("product")
    @Expose
    var products: String?,

    @SerializedName("discount")
    @Expose
    var discount: String?,

    @SerializedName("discount_status")
    @Expose
    var discountStatus: String?,

    /*@SerializedName("discount_amount")
    @Expose
    private val discountAmount: String?,*/

    @SerializedName("invoice_count")
    @Expose
    var invoiceCount: String?,

    @SerializedName("round_amount")
    @Expose
    var roundAmount: String?,

    //new added field
    @SerializedName("tds")
    @Expose
    var tds: String?,

    @SerializedName("account_holder_name")
    @Expose
    var accountHolderName: String?,

    @SerializedName("account_number")
    @Expose
    var accountNumber: String?,

    @SerializedName("ifsc_code")
    @Expose
    var ifscCode: String?,

    @SerializedName("bank_detail")
    @Expose
    var bankDetail: String?,

    @SerializedName("balance_due")
    @Expose
    var balanceDue: String?,

    @SerializedName("import_id")
    @Expose
    var importId: String?,

    @SerializedName("delivery_to_name")
    @Expose
    var deliveryToName: String?,

    @SerializedName("delivery_address")
    @Expose
    var deliveryAddress: String?,


    @SerializedName("purchase_order_no")
    @Expose
    var purchaseOrderNo: String?,

    @SerializedName("purchase_order_date")
    @Expose
    var purchaseOrderDate: String?,

    @SerializedName("paid_amount")
    @Expose
    var paidAmount: String?,

    @SerializedName("credit_note_id")
    @Expose
    var creditNoteId: String?,

    @SerializedName("amount_received")
    @Expose
    var amountReceived: String?,

    @SerializedName("payment_mode")
    @Expose
    var modePayment: String?,

    /*@SerializedName("user_invoice_product")
    @Expose
    var userInvoiceProduct: List<Data>?,*/

    // for debtor list
    @SerializedName("paid_unpaid")
    @Expose
    var paidUnpaid: String?,

    @SerializedName("purpose_transport")
    @Expose
    var purposeTransport: String?,

    @SerializedName("eway_bill_no")
    @Expose
    var eway_bill_no: String?,

    @SerializedName("document_type")
    @Expose
    val documentType: String?,

    @SerializedName("place_delivery")
    @Expose
    val placeDelivery: String?,

    @SerializedName("approx_distance")
    @Expose
    val approxDistance: String?,

    @SerializedName("transport_name")
    @Expose
    val transportName: String?,

    @SerializedName("transport_gst")
    @Expose
    val transportGst: String?,

    @SerializedName("transport_mode")
    @Expose
    val transportMode: String?,

    @SerializedName("vehicle_no")
    @Expose
    val vehicleNo: String?,

    @SerializedName("vehicle_type")
    @Expose
    val vehicleType: String?,

    @SerializedName("transport_doc_no")
    @Expose
    val transportDocNo: String?,

    @SerializedName("transport_date")
    @Expose
    val transportDate: String?,

    @SerializedName("city")
    @Expose
    var city: String?,

    @SerializedName("eway_bill_date")
    @Expose
    val ewayBillDate: String?,

    @SerializedName("eway_valid_upto")
    @Expose
    val ewayValidUpto: String?,

    @SerializedName("pincode")
    @Expose
    var pincode: String?,

    @SerializedName("buyer_refrence")
    @Expose
    var buyerRefrence: String?,

    @SerializedName("credit_invoice_id")
    @Expose
    var creditInvoiceId: String?,

    @SerializedName("delivery_chalan_status")
    @Expose
    val deliveryChalanStatus: String?,

    @SerializedName("delivery_chalan_id")
    @Expose
    val deliveryChalanId: String?,

    @SerializedName("reward_id")
    @Expose
    var rewardId: String?,

    @SerializedName("reward_user_id")
    @Expose
    var rewardUserId: String?,

    @SerializedName("shipping_name")
    @Expose
    var shipping_name: String?,

    @SerializedName("customer_name")
    @Expose
    var customer_name: String?,

    @SerializedName("mobile")
    @Expose
    var mobile: String?

)