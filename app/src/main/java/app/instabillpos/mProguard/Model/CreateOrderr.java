package app.instabillpos.mProguard.Model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "offlineInvoice")
public class CreateOrderr {
    @NonNull
    @PrimaryKey
    @SerializedName("temp_invoice_number")
    @Expose
    private String temp_invoice_number;
    @SerializedName("company_id")
    @Expose
    private String company_id;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("change_amt")
    @Expose
    private String change;


    @SerializedName("invoice_id")
    @Expose
    private String invoiceId;
    @SerializedName("variant")
    @Expose
    private Integer variant;

    @SerializedName("quot_id")
    @Expose
    private String quotId;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("invoice_no")
    @Expose
    private String invoiceNo;

    @SerializedName("invoice_date")
    @Expose
    private String invoiceDate;

    @SerializedName("credit_note_date")
    @Expose
    private String creditNoteDate;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("gstin")
    @Expose
    private String gstin;
    @SerializedName("place_supply")
    @Expose
    private String placeOfSupply;
    @SerializedName("tax_type")
    @Expose
    private String taxType;
    @SerializedName("due_terms")
    @Expose
    private String dueTerm;
    @SerializedName("supply_code")
    @Expose
    private String supplyCode;
    @SerializedName("sub_total")
    @Expose
    private String subTotal;
    @SerializedName("cgst")
    @Expose
    private String cgst;
    @SerializedName("sgst")
    @Expose
    private String sgst;
    @SerializedName("igst")
    @Expose
    private String igst;
    @SerializedName("cess_charge")
    @Expose
    private String cessTotal;
    @SerializedName("cess_amount")
    @Expose
    private String cessAmount;
    @SerializedName("shipping_charge")
    @Expose
    private String shippingCharge;
    @SerializedName("customer_email")
    @Expose
    private String customerEmail;
    @SerializedName("customer_id")
    @Expose
    private Integer customerId;

    @SerializedName("total")
    @Expose
    private String totalBalance;
    @SerializedName("fotter")
    @Expose
    private String footer;
    @SerializedName("product")
    @Expose
    private String products;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("discount_status")
    @Expose
    private String discountStatus;
    @SerializedName("discount_amount")
    @Expose
    private String discountAmount;
    @SerializedName("invoice_count")
    @Expose
    private String invoiceCount;
    @SerializedName("round_amount")
    @Expose
    private String roundAmount;

    //new added field

    @SerializedName("tds")
    @Expose
    private String tds;

    @SerializedName("account_holder_name")
    @Expose
    private String accountHolderName;
    @SerializedName("account_number")
    @Expose
    private String accountNumber;
    @SerializedName("ifsc_code")
    @Expose
    private String ifscCode;
    @SerializedName("bank_detail")
    @Expose
    private String bankDetail;

    @SerializedName("balance_due")
    @Expose
    private String balanceDue;

    @SerializedName("import_id")
    @Expose
    private String importId;

    @SerializedName("delivery_to_name")
    @Expose
    private String deliveryToName;
    @SerializedName("delivery_address")
    @Expose
    private String deliveryAddress;
    @SerializedName("setting_invoice_number")
    @Expose
    private String settingInvoiceNumber;
    @SerializedName("purchase_order_no")
    @Expose
    private String purchaseOrderNo;
    @SerializedName("purchase_order_date")
    @Expose
    private String purchaseOrderDate;


    @SerializedName("paid_amount")
    @Expose
    private String paidAmount;

    @SerializedName("credit_note_id")
    @Expose
    private String creditNoteId;

    @SerializedName("amount_received")
    @Expose
    private String amountReceived;
    @SerializedName("payment_mode")
    @Expose
    private String modePayment;


    /* @SerializedName("user_invoice_product")
     @Expose
     private List<Data> userInvoiceProduct = null;*/
    // for debtor list
    @SerializedName("paid_unpaid")
    @Expose
    private String paidUnpaid;

    @SerializedName("purpose_transport")
    @Expose
    private String purposeTransport;
    @SerializedName("eway_bill_no")
    @Expose
    private String eway_bill_no;


    @SerializedName("document_type")
    @Expose
    private String documentType;
    @SerializedName("place_delivery")
    @Expose
    private String placeDelivery;
    @SerializedName("approx_distance")
    @Expose
    private String approxDistance;
    @SerializedName("transport_name")
    @Expose
    private String transportName;
    @SerializedName("transport_gst")
    @Expose
    private String transportGst;
    @SerializedName("transport_mode")
    @Expose
    private String transportMode;
    @SerializedName("vehicle_no")
    @Expose
    private String vehicleNo;
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;
    @SerializedName("transport_doc_no")
    @Expose
    private String transportDocNo;
    @SerializedName("transport_date")
    @Expose
    private String transportDate;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("eway_bill_date")
    @Expose
    private String ewayBillDate;
    @SerializedName("eway_valid_upto")
    @Expose
    private String ewayValidUpto;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("buyer_refrence")
    @Expose
    private String buyerRefrence;
    @SerializedName("credit_invoice_id")
    @Expose
    private String creditInvoiceId;
    @SerializedName("delivery_chalan_status")
    @Expose
    private String deliveryChalanStatus;

    @SerializedName("delivery_chalan_id")

    @Expose
    private String deliveryChalanId;

    @SerializedName("reward_id")
    @Expose
    private String rewardId;

    @SerializedName("reward_user_id")
    @Expose
    private String rewardUserId;

    @SerializedName("shipping_name")
    @Expose
    private String shipping_name;

    @SerializedName("customer_name")
    @Expose
    private String customer_name;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("purchase_description")
    @Expose
    private String purchase_description;
    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPurchase_description() {
        return purchase_description;
    }

    public void setPurchase_description(String purchase_description) {
        this.purchase_description = purchase_description;
    }

    public String getTemp_invoice_number() {
        return temp_invoice_number;
    }

    public void setTemp_invoice_number(String temp_invoice_number) {
        this.temp_invoice_number = temp_invoice_number;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getSettingInvoiceNumber() {
        return settingInvoiceNumber;
    }

    public void setSettingInvoiceNumber(String settingInvoiceNumber) {
        this.settingInvoiceNumber = settingInvoiceNumber;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public Integer getVariant() {
        return variant;
    }

    public void setVariant(Integer variant) {
        this.variant = variant;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getShipping_name() {
        return shipping_name;
    }

    public void setShipping_name(String shipping_name) {
        this.shipping_name = shipping_name;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardUserId() {
        return rewardUserId;
    }

    public void setRewardUserId(String rewardUserId) {
        this.rewardUserId = rewardUserId;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public String getInvoiceCount() {
        return invoiceCount;
    }

    public void setInvoiceCount(String invoiceCount) {
        this.invoiceCount = invoiceCount;
    }

    public String getPaidUnpaid() {
        return paidUnpaid;
    }

    public void setPaidUnpaid(String paidUnpaid) {
        this.paidUnpaid = paidUnpaid;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getQuotId() {
        return quotId;
    }

    public void setQuotId(String quotId) {
        this.quotId = quotId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getPlaceOfSupply() {
        return placeOfSupply;
    }

    public void setPlaceOfSupply(String placeOfSupply) {
        this.placeOfSupply = placeOfSupply;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getDueTerm() {
        return dueTerm;
    }

    public void setDueTerm(String dueTerm) {
        this.dueTerm = dueTerm;
    }

    public String getSupplyCode() {
        return supplyCode;
    }

    public void setSupplyCode(String supplyCode) {
        this.supplyCode = supplyCode;
    }

    public String getRoundAmount() {
        return roundAmount;
    }

    public void setRoundAmount(String roundAmount) {
        this.roundAmount = roundAmount;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getCgst() {
        return cgst;
    }

    public void setCgst(String cgst) {
        this.cgst = cgst;
    }

    public String getSgst() {
        return sgst;
    }

    public void setSgst(String sgst) {
        this.sgst = sgst;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getIgst() {
        return igst;
    }

    public void setIgst(String igst) {
        this.igst = igst;
    }

    public String getCessTotal() {
        return cessTotal;
    }

    public void setCessTotal(String cessTotal) {
        this.cessTotal = cessTotal;
    }

    public String getCessAmount() {
        return cessAmount;
    }

    public void setCessAmount(String cessAmount) {
        this.cessAmount = cessAmount;
    }

    public String getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(String shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getPurposeTransport() {
        return purposeTransport;
    }

    public void setPurposeTransport(String purposeTransport) {
        this.purposeTransport = purposeTransport;
    }

    public String getEway_bill_no() {
        return eway_bill_no;
    }

    public void setEway_bill_no(String eway_bill_no) {
        this.eway_bill_no = eway_bill_no;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getPlaceDelivery() {
        return placeDelivery;
    }

    public void setPlaceDelivery(String placeDelivery) {
        this.placeDelivery = placeDelivery;
    }

    public String getApproxDistance() {
        return approxDistance;
    }

    public void setApproxDistance(String approxDistance) {
        this.approxDistance = approxDistance;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getTransportGst() {
        return transportGst;
    }

    public void setTransportGst(String transportGst) {
        this.transportGst = transportGst;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getTransportDocNo() {
        return transportDocNo;
    }

    public void setTransportDocNo(String transportDocNo) {
        this.transportDocNo = transportDocNo;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEwayBillDate() {
        return ewayBillDate;
    }

    public void setEwayBillDate(String ewayBillDate) {
        this.ewayBillDate = ewayBillDate;
    }

    public String getEwayValidUpto() {
        return ewayValidUpto;
    }

    public void setEwayValidUpto(String ewayValidUpto) {
        this.ewayValidUpto = ewayValidUpto;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public String getBankDetail() {
        return bankDetail;
    }

    public void setBankDetail(String bankDetail) {
        this.bankDetail = bankDetail;
    }

    public String getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(String balanceDue) {
        this.balanceDue = balanceDue;
    }

    public String getDeliveryToName() {
        return deliveryToName;
    }

    public void setDeliveryToName(String deliveryToName) {
        this.deliveryToName = deliveryToName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getPurchaseOrderDate() {
        return purchaseOrderDate;
    }

    public void setPurchaseOrderDate(String purchaseOrderDate) {
        this.purchaseOrderDate = purchaseOrderDate;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getDiscountStatus() {
        return discountStatus;
    }

    public void setDiscountStatus(String discountStatus) {
        this.discountStatus = discountStatus;
    }

    public String getDeliveryChalanStatus() {
        return deliveryChalanStatus;
    }

    public void setDeliveryChalanStatus(String deliveryChalanStatus) {
        this.deliveryChalanStatus = deliveryChalanStatus;
    }

    public String getDeliveryChalanId() {
        return deliveryChalanId;
    }

    public void setDeliveryChalanId(String deliveryChalanId) {
        this.deliveryChalanId = deliveryChalanId;
    }

    public String getBuyerRefrence() {
        return buyerRefrence;
    }

    public void setBuyerRefrence(String buyerRefrence) {
        this.buyerRefrence = buyerRefrence;
    }

    public String getCreditInvoiceId() {
        return creditInvoiceId;
    }

    public void setCreditInvoiceId(String creditInvoiceId) {
        this.creditInvoiceId = creditInvoiceId;
    }

    public String getCreditNoteDate() {
        return creditNoteDate;
    }

    public void setCreditNoteDate(String creditNoteDate) {
        this.creditNoteDate = creditNoteDate;
    }

    public String getCreditNoteId() {
        return creditNoteId;
    }

    public void setCreditNoteId(String creditNoteId) {
        this.creditNoteId = creditNoteId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(String amountReceived) {
        this.amountReceived = amountReceived;
    }

    public String getModePayment() {
        return modePayment;
    }

    public void setModePayment(String modePayment) {
        this.modePayment = modePayment;
    }
}

