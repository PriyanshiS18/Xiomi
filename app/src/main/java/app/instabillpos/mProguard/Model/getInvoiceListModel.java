package app.instabillpos.mProguard.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class getInvoiceListModel {
    @SerializedName("errorCode")
    @Expose
    private String errorCode;
    @SerializedName("errorMsg")
    @Expose
    private String errorMsg;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("payment_mode")
        @Expose
        private String paymentMode;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("invoice_id")
        @Expose
        private String invoiceId;
        @SerializedName("temp_invoice_number")
        @Expose
        private Object tempInvoiceNumber;
        @SerializedName("quot_id")
        @Expose
        private Object quotId;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("company_name")
        @Expose
        private String companyName;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("customer_name")
        @Expose
        private Object customerName;
        @SerializedName("mobile")
        @Expose
        private Object mobile;
        @SerializedName("customer_id")
        @Expose
        private String customerId;
        @SerializedName("pincode")
        @Expose
        private String pincode;
        @SerializedName("gstin")
        @Expose
        private Object gstin;
        @SerializedName("place_supply")
        @Expose
        private String placeSupply;
        @SerializedName("supply_code")
        @Expose
        private String supplyCode;
        @SerializedName("sub_total")
        @Expose
        private String subTotal;
        @SerializedName("discount")
        @Expose
        private String discount;
        @SerializedName("discount_status")
        @Expose
        private String discountStatus;
        @SerializedName("cgst")
        @Expose
        private String cgst;
        @SerializedName("sgst")
        @Expose
        private String sgst;
        @SerializedName("igst")
        @Expose
        private String igst;
        @SerializedName("cess_amount")
        @Expose
        private String cessAmount;
        @SerializedName("tds")
        @Expose
        private Object tds;
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
        private Object bankDetail;
        @SerializedName("delivery_to_name")
        @Expose
        private String deliveryToName;
        @SerializedName("delivery_address")
        @Expose
        private String deliveryAddress;
        @SerializedName("purchase_order_no")
        @Expose
        private String purchaseOrderNo;
        @SerializedName("purchase_order_date")
        @Expose
        private String purchaseOrderDate;
        @SerializedName("shipping_charge")
        @Expose
        private String shippingCharge;
        @SerializedName("total")
        @Expose
        private String total;
        @SerializedName("round_amount")
        @Expose
        private String roundAmount;
        @SerializedName("balance_due")
        @Expose
        private String balanceDue;
        @SerializedName("fotter")
        @Expose
        private Object fotter;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("paid_unpaid")
        @Expose
        private String paidUnpaid;
        @SerializedName("supply")
        @Expose
        private String supply;
        @SerializedName("purpose_transport")
        @Expose
        private String purposeTransport;
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
        @SerializedName("state")
        @Expose
        private Object state;
        @SerializedName("eway_bill_no")
        @Expose
        private Object ewayBillNo;
        @SerializedName("eway_bill_date")
        @Expose
        private Object ewayBillDate;
        @SerializedName("eway_valid_upto")
        @Expose
        private Object ewayValidUpto;
        @SerializedName("reason")
        @Expose
        private Object reason;
        @SerializedName("cancel_reject")
        @Expose
        private Object cancelReject;
        @SerializedName("tax_type")
        @Expose
        private String taxType;
        @SerializedName("due_terms")
        @Expose
        private String dueTerms;
        @SerializedName("import_id")
        @Expose
        private String importId;
        @SerializedName("delete_status")
        @Expose
        private String deleteStatus;
        @SerializedName("purchase_order_id")
        @Expose
        private String purchaseOrderId;
        @SerializedName("csv_data_import_id")
        @Expose
        private Object csvDataImportId;
        @SerializedName("delivery_chalan_status")
        @Expose
        private String deliveryChalanStatus;
        @SerializedName("delivery_chalan_id")
        @Expose
        private String deliveryChalanId;
        @SerializedName("credit_note_id")
        @Expose
        private String creditNoteId;
        @SerializedName("shipping_name")
        @Expose
        private String shippingName;
        @SerializedName("variant")
        @Expose
        private String variant;
        @SerializedName("change_amt")
        @Expose
        private String changeAmt;
        @SerializedName("paid_amount")
        @Expose
        private String paidAmount;
        @SerializedName("amount_received")
        @Expose
        private String amountReceived;
        @SerializedName("customer_email")
        @Expose
        private String customerEmail;
        @SerializedName("user_invoice_product")
        @Expose
        private List<UserInvoiceProduct> userInvoiceProduct = null;

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
        }

        public Object getTempInvoiceNumber() {
            return tempInvoiceNumber;
        }

        public void setTempInvoiceNumber(Object tempInvoiceNumber) {
            this.tempInvoiceNumber = tempInvoiceNumber;
        }

        public Object getQuotId() {
            return quotId;
        }

        public void setQuotId(Object quotId) {
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

        public Object getCustomerName() {
            return customerName;
        }

        public void setCustomerName(Object customerName) {
            this.customerName = customerName;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public Object getGstin() {
            return gstin;
        }

        public void setGstin(Object gstin) {
            this.gstin = gstin;
        }

        public String getPlaceSupply() {
            return placeSupply;
        }

        public void setPlaceSupply(String placeSupply) {
            this.placeSupply = placeSupply;
        }

        public String getSupplyCode() {
            return supplyCode;
        }

        public void setSupplyCode(String supplyCode) {
            this.supplyCode = supplyCode;
        }

        public String getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(String subTotal) {
            this.subTotal = subTotal;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscountStatus() {
            return discountStatus;
        }

        public void setDiscountStatus(String discountStatus) {
            this.discountStatus = discountStatus;
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

        public String getIgst() {
            return igst;
        }

        public void setIgst(String igst) {
            this.igst = igst;
        }

        public String getCessAmount() {
            return cessAmount;
        }

        public void setCessAmount(String cessAmount) {
            this.cessAmount = cessAmount;
        }

        public Object getTds() {
            return tds;
        }

        public void setTds(Object tds) {
            this.tds = tds;
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

        public Object getBankDetail() {
            return bankDetail;
        }

        public void setBankDetail(Object bankDetail) {
            this.bankDetail = bankDetail;
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

        public String getShippingCharge() {
            return shippingCharge;
        }

        public void setShippingCharge(String shippingCharge) {
            this.shippingCharge = shippingCharge;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getRoundAmount() {
            return roundAmount;
        }

        public void setRoundAmount(String roundAmount) {
            this.roundAmount = roundAmount;
        }

        public String getBalanceDue() {
            return balanceDue;
        }

        public void setBalanceDue(String balanceDue) {
            this.balanceDue = balanceDue;
        }

        public Object getFotter() {
            return fotter;
        }

        public void setFotter(Object fotter) {
            this.fotter = fotter;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getPaidUnpaid() {
            return paidUnpaid;
        }

        public void setPaidUnpaid(String paidUnpaid) {
            this.paidUnpaid = paidUnpaid;
        }

        public String getSupply() {
            return supply;
        }

        public void setSupply(String supply) {
            this.supply = supply;
        }

        public String getPurposeTransport() {
            return purposeTransport;
        }

        public void setPurposeTransport(String purposeTransport) {
            this.purposeTransport = purposeTransport;
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

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public Object getEwayBillNo() {
            return ewayBillNo;
        }

        public void setEwayBillNo(Object ewayBillNo) {
            this.ewayBillNo = ewayBillNo;
        }

        public Object getEwayBillDate() {
            return ewayBillDate;
        }

        public void setEwayBillDate(Object ewayBillDate) {
            this.ewayBillDate = ewayBillDate;
        }

        public Object getEwayValidUpto() {
            return ewayValidUpto;
        }

        public void setEwayValidUpto(Object ewayValidUpto) {
            this.ewayValidUpto = ewayValidUpto;
        }

        public Object getReason() {
            return reason;
        }

        public void setReason(Object reason) {
            this.reason = reason;
        }

        public Object getCancelReject() {
            return cancelReject;
        }

        public void setCancelReject(Object cancelReject) {
            this.cancelReject = cancelReject;
        }

        public String getTaxType() {
            return taxType;
        }

        public void setTaxType(String taxType) {
            this.taxType = taxType;
        }

        public String getDueTerms() {
            return dueTerms;
        }

        public void setDueTerms(String dueTerms) {
            this.dueTerms = dueTerms;
        }

        public String getImportId() {
            return importId;
        }

        public void setImportId(String importId) {
            this.importId = importId;
        }

        public String getDeleteStatus() {
            return deleteStatus;
        }

        public void setDeleteStatus(String deleteStatus) {
            this.deleteStatus = deleteStatus;
        }

        public String getPurchaseOrderId() {
            return purchaseOrderId;
        }

        public void setPurchaseOrderId(String purchaseOrderId) {
            this.purchaseOrderId = purchaseOrderId;
        }

        public Object getCsvDataImportId() {
            return csvDataImportId;
        }

        public void setCsvDataImportId(Object csvDataImportId) {
            this.csvDataImportId = csvDataImportId;
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

        public String getCreditNoteId() {
            return creditNoteId;
        }

        public void setCreditNoteId(String creditNoteId) {
            this.creditNoteId = creditNoteId;
        }

        public String getShippingName() {
            return shippingName;
        }

        public void setShippingName(String shippingName) {
            this.shippingName = shippingName;
        }

        public String getVariant() {
            return variant;
        }

        public void setVariant(String variant) {
            this.variant = variant;
        }

        public String getChangeAmt() {
            return changeAmt;
        }

        public void setChangeAmt(String changeAmt) {
            this.changeAmt = changeAmt;
        }

        public String getPaidAmount() {
            return paidAmount;
        }

        public void setPaidAmount(String paidAmount) {
            this.paidAmount = paidAmount;
        }

        public String getAmountReceived() {
            return amountReceived;
        }

        public void setAmountReceived(String amountReceived) {
            this.amountReceived = amountReceived;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public List<UserInvoiceProduct> getUserInvoiceProduct() {
            return userInvoiceProduct;
        }

        public void setUserInvoiceProduct(List<UserInvoiceProduct> userInvoiceProduct) {
            this.userInvoiceProduct = userInvoiceProduct;
        }

        public class UserInvoiceProduct {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("user_id")
            @Expose
            private String userId;
            @SerializedName("company_id")
            @Expose
            private String companyId;
            @SerializedName("invoice_id")
            @Expose
            private String invoiceId;
            @SerializedName("product_id")
            @Expose
            private String productId;
            @SerializedName("product_id_two")
            @Expose
            private Object productIdTwo;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("date")
            @Expose
            private String date;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("product_type")
            @Expose
            private String productType;
            @SerializedName("product_rate")
            @Expose
            private String productRate;
            @SerializedName("product_unit")
            @Expose
            private String productUnit;
            @SerializedName("hsn")
            @Expose
            private String hsn;
            @SerializedName("tax_rate")
            @Expose
            private String taxRate;
            @SerializedName("cess_charge")
            @Expose
            private String cessCharge;
            @SerializedName("discount")
            @Expose
            private String discount;
            @SerializedName("discount_value")
            @Expose
            private String discountValue;
            @SerializedName("discount_status")
            @Expose
            private String discountStatus;
            @SerializedName("discount_amount")
            @Expose
            private String discountAmount;
            @SerializedName("cgst")
            @Expose
            private String cgst;
            @SerializedName("sgst")
            @Expose
            private String sgst;
            @SerializedName("igst")
            @Expose
            private String igst;
            @SerializedName("taxable_value")
            @Expose
            private String taxableValue;
            @SerializedName("import_id")
            @Expose
            private String importId;
            @SerializedName("barcode_id")
            @Expose
            private String barcodeId;
            @SerializedName("delete_status")
            @Expose
            private String deleteStatus;
            @SerializedName("created")
            @Expose
            private String created;
            @SerializedName("product_detail")
            @Expose
            private ProductDetail productDetail;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getCompanyId() {
                return companyId;
            }

            public void setCompanyId(String companyId) {
                this.companyId = companyId;
            }

            public String getInvoiceId() {
                return invoiceId;
            }

            public void setInvoiceId(String invoiceId) {
                this.invoiceId = invoiceId;
            }

            public String getProductId() {
                return productId;
            }

            public void setProductId(String productId) {
                this.productId = productId;
            }

            public Object getProductIdTwo() {
                return productIdTwo;
            }

            public void setProductIdTwo(Object productIdTwo) {
                this.productIdTwo = productIdTwo;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getProductType() {
                return productType;
            }

            public void setProductType(String productType) {
                this.productType = productType;
            }

            public String getProductRate() {
                return productRate;
            }

            public void setProductRate(String productRate) {
                this.productRate = productRate;
            }

            public String getProductUnit() {
                return productUnit;
            }

            public void setProductUnit(String productUnit) {
                this.productUnit = productUnit;
            }

            public String getHsn() {
                return hsn;
            }

            public void setHsn(String hsn) {
                this.hsn = hsn;
            }

            public String getTaxRate() {
                return taxRate;
            }

            public void setTaxRate(String taxRate) {
                this.taxRate = taxRate;
            }

            public String getCessCharge() {
                return cessCharge;
            }

            public void setCessCharge(String cessCharge) {
                this.cessCharge = cessCharge;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getDiscountValue() {
                return discountValue;
            }

            public void setDiscountValue(String discountValue) {
                this.discountValue = discountValue;
            }

            public String getDiscountStatus() {
                return discountStatus;
            }

            public void setDiscountStatus(String discountStatus) {
                this.discountStatus = discountStatus;
            }

            public String getDiscountAmount() {
                return discountAmount;
            }

            public void setDiscountAmount(String discountAmount) {
                this.discountAmount = discountAmount;
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

            public String getIgst() {
                return igst;
            }

            public void setIgst(String igst) {
                this.igst = igst;
            }

            public String getTaxableValue() {
                return taxableValue;
            }

            public void setTaxableValue(String taxableValue) {
                this.taxableValue = taxableValue;
            }

            public String getImportId() {
                return importId;
            }

            public void setImportId(String importId) {
                this.importId = importId;
            }

            public String getBarcodeId() {
                return barcodeId;
            }

            public void setBarcodeId(String barcodeId) {
                this.barcodeId = barcodeId;
            }

            public String getDeleteStatus() {
                return deleteStatus;
            }

            public void setDeleteStatus(String deleteStatus) {
                this.deleteStatus = deleteStatus;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public ProductDetail getProductDetail() {
                return productDetail;
            }

            public void setProductDetail(ProductDetail productDetail) {
                this.productDetail = productDetail;
            }


            public class ProductDetail {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("company_id")
                @Expose
                private String companyId;
                @SerializedName("user_id")
                @Expose
                private String userId;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("description")
                @Expose
                private String description;
                @SerializedName("product_type")
                @Expose
                private String productType;
                @SerializedName("product_rate")
                @Expose
                private String productRate;
                @SerializedName("product_unit")
                @Expose
                private String productUnit;
                @SerializedName("hsn")
                @Expose
                private String hsn;
                @SerializedName("tax_rate")
                @Expose
                private String taxRate;
                @SerializedName("cess_charge")
                @Expose
                private String cessCharge;
                @SerializedName("discount")
                @Expose
                private String discount;
                @SerializedName("discount_value")
                @Expose
                private String discountValue;
                @SerializedName("import_id")
                @Expose
                private String importId;
                @SerializedName("barcode_id")
                @Expose
                private String barcodeId;
                @SerializedName("purchase_status")
                @Expose
                private String purchaseStatus;
                @SerializedName("sku")
                @Expose
                private String sku;
                @SerializedName("reorder_level")
                @Expose
                private Object reorderLevel;
                @SerializedName("opening_stock_quantity")
                @Expose
                private String openingStockQuantity;
                @SerializedName("opening_stock_value")
                @Expose
                private String openingStockValue;
                @SerializedName("reorder_level_quantity")
                @Expose
                private String reorderLevelQuantity;
                @SerializedName("product_status")
                @Expose
                private String productStatus;
                @SerializedName("raw_materail_status")
                @Expose
                private String rawMaterailStatus;
                @SerializedName("purchase_inventory_status")
                @Expose
                private String purchaseInventoryStatus;
                @SerializedName("sales_inventory_status")
                @Expose
                private String salesInventoryStatus;
                @SerializedName("track_inventory_status")
                @Expose
                private String trackInventoryStatus;
                @SerializedName("date")
                @Expose
                private Object date;
                @SerializedName("purchase_rate")
                @Expose
                private String purchaseRate;
                @SerializedName("purchase_description")
                @Expose
                private String purchaseDescription;
                @SerializedName("product_categorey")
                @Expose
                private String productCategorey;
                @SerializedName("image")
                @Expose
                private Object image;
                @SerializedName("product_categorey_old")
                @Expose
                private String productCategoreyOld;
                @SerializedName("batch_no")
                @Expose
                private String batchNo;
                @SerializedName("manufacturing_date")
                @Expose
                private String manufacturingDate;
                @SerializedName("expiry_date")
                @Expose
                private String expiryDate;
                @SerializedName("mrp")
                @Expose
                private String mrp;
                @SerializedName("created")
                @Expose
                private String created;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getCompanyId() {
                    return companyId;
                }

                public void setCompanyId(String companyId) {
                    this.companyId = companyId;
                }

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getProductType() {
                    return productType;
                }

                public void setProductType(String productType) {
                    this.productType = productType;
                }

                public String getProductRate() {
                    return productRate;
                }

                public void setProductRate(String productRate) {
                    this.productRate = productRate;
                }

                public String getProductUnit() {
                    return productUnit;
                }

                public void setProductUnit(String productUnit) {
                    this.productUnit = productUnit;
                }

                public String getHsn() {
                    return hsn;
                }

                public void setHsn(String hsn) {
                    this.hsn = hsn;
                }

                public String getTaxRate() {
                    return taxRate;
                }

                public void setTaxRate(String taxRate) {
                    this.taxRate = taxRate;
                }

                public String getCessCharge() {
                    return cessCharge;
                }

                public void setCessCharge(String cessCharge) {
                    this.cessCharge = cessCharge;
                }

                public String getDiscount() {
                    return discount;
                }

                public void setDiscount(String discount) {
                    this.discount = discount;
                }

                public String getDiscountValue() {
                    return discountValue;
                }

                public void setDiscountValue(String discountValue) {
                    this.discountValue = discountValue;
                }

                public String getImportId() {
                    return importId;
                }

                public void setImportId(String importId) {
                    this.importId = importId;
                }

                public String getBarcodeId() {
                    return barcodeId;
                }

                public void setBarcodeId(String barcodeId) {
                    this.barcodeId = barcodeId;
                }

                public String getPurchaseStatus() {
                    return purchaseStatus;
                }

                public void setPurchaseStatus(String purchaseStatus) {
                    this.purchaseStatus = purchaseStatus;
                }

                public String getSku() {
                    return sku;
                }

                public void setSku(String sku) {
                    this.sku = sku;
                }

                public Object getReorderLevel() {
                    return reorderLevel;
                }

                public void setReorderLevel(Object reorderLevel) {
                    this.reorderLevel = reorderLevel;
                }

                public String getOpeningStockQuantity() {
                    return openingStockQuantity;
                }

                public void setOpeningStockQuantity(String openingStockQuantity) {
                    this.openingStockQuantity = openingStockQuantity;
                }

                public String getOpeningStockValue() {
                    return openingStockValue;
                }

                public void setOpeningStockValue(String openingStockValue) {
                    this.openingStockValue = openingStockValue;
                }

                public String getReorderLevelQuantity() {
                    return reorderLevelQuantity;
                }

                public void setReorderLevelQuantity(String reorderLevelQuantity) {
                    this.reorderLevelQuantity = reorderLevelQuantity;
                }

                public String getProductStatus() {
                    return productStatus;
                }

                public void setProductStatus(String productStatus) {
                    this.productStatus = productStatus;
                }

                public String getRawMaterailStatus() {
                    return rawMaterailStatus;
                }

                public void setRawMaterailStatus(String rawMaterailStatus) {
                    this.rawMaterailStatus = rawMaterailStatus;
                }

                public String getPurchaseInventoryStatus() {
                    return purchaseInventoryStatus;
                }

                public void setPurchaseInventoryStatus(String purchaseInventoryStatus) {
                    this.purchaseInventoryStatus = purchaseInventoryStatus;
                }

                public String getSalesInventoryStatus() {
                    return salesInventoryStatus;
                }

                public void setSalesInventoryStatus(String salesInventoryStatus) {
                    this.salesInventoryStatus = salesInventoryStatus;
                }

                public String getTrackInventoryStatus() {
                    return trackInventoryStatus;
                }

                public void setTrackInventoryStatus(String trackInventoryStatus) {
                    this.trackInventoryStatus = trackInventoryStatus;
                }

                public Object getDate() {
                    return date;
                }

                public void setDate(Object date) {
                    this.date = date;
                }

                public String getPurchaseRate() {
                    return purchaseRate;
                }

                public void setPurchaseRate(String purchaseRate) {
                    this.purchaseRate = purchaseRate;
                }

                public String getPurchaseDescription() {
                    return purchaseDescription;
                }

                public void setPurchaseDescription(String purchaseDescription) {
                    this.purchaseDescription = purchaseDescription;
                }

                public String getProductCategorey() {
                    return productCategorey;
                }

                public void setProductCategorey(String productCategorey) {
                    this.productCategorey = productCategorey;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }

                public String getProductCategoreyOld() {
                    return productCategoreyOld;
                }

                public void setProductCategoreyOld(String productCategoreyOld) {
                    this.productCategoreyOld = productCategoreyOld;
                }

                public String getBatchNo() {
                    return batchNo;
                }

                public void setBatchNo(String batchNo) {
                    this.batchNo = batchNo;
                }

                public String getManufacturingDate() {
                    return manufacturingDate;
                }

                public void setManufacturingDate(String manufacturingDate) {
                    this.manufacturingDate = manufacturingDate;
                }

                public String getExpiryDate() {
                    return expiryDate;
                }

                public void setExpiryDate(String expiryDate) {
                    this.expiryDate = expiryDate;
                }

                public String getMrp() {
                    return mrp;
                }

                public void setMrp(String mrp) {
                    this.mrp = mrp;
                }

                public String getCreated() {
                    return created;
                }

                public void setCreated(String created) {
                    this.created = created;
                }

            }

        }

    }

}
