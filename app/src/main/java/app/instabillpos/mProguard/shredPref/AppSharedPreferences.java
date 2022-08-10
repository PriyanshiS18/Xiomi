package app.instabillpos.mProguard.shredPref;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class AppSharedPreferences {
    public static String INVOICEVIEW = "isInvoiceShowView";
    public static String PRODUCTVIEW = "isProductShowView";
    public static String QUOATATIONVIEW = "isQuoatationShowView";
    public static String PURCHASEORDERVIEW = "isPurchaseOrderShowView";
    public static String PURCHASEVIEW = "isPurchaseShowView";
    public static String DASHBOARDVIEW = "isDashBoardShowView";
    public static String NAVIGATION = "navigation";
    public static String INVOICEMANUAL = "invoice_manual";
    public static String DEBITNOTEMANUAL = "debitnote_manual";
    public static String CREDITNOTEMANUAL = "creditnote_manual";
    public static String QUOTATIONEMANUAL = "quo_manual";
    public static String POMANUAL = "po_manual";
    public static String REVENUEAMOUT = "revenueamount";
    public static String EXPENSESAMOUNT = "expensesamount";
    public static String PACKAGE_ID = "package_id";
    public static String PACKAGE_PLAN = "package_plan";
    public static String PLAN_TIME = "plan_time";
    public static String PLAN_PRICE = "plan_price";
    public static String USER_ID = "user_id";
    public static String ROUND_OFF = "round_off";
    public static String CREDIT_NOTE_FOOTER = "credit_note_footer";
    public static String CREDIT_NOTE_PDF_HEADER = "credit_notepdf_header";
    public static String CREDIT_NOTE_PREFIX = "credit_note_prefix";
    public static String DEBIT_NOTE_FOOTER = "debit_note_footer";
    public static String DEBIT_NOTE_PDF_HEADER = "debit_notepdf_header";
    public static String DEBIT_NOTE_PREFIX = "debit_note_prefix";
    public static String LOGINTIME = "login_time";
    public static String PARENT_USER = "parent_user";
    public static String SALESPERMISSION = "salespermission";
    public static String PURCHASESPERMISSION = "purchasespermission";
    public static String EXPENSESSPERMISSION = "expensespermission";
    public static String VENDORPERMISSION = "vendorpermission";
    public static String CUSTOMERPERMISSION = "customerpermission";
    public static String REPORTPERMISSION = "reportpermission";
    public static String PRODUCTRPERMISSION = "productpermission";
    public static String INVENTORYPERMISSION = "inventorypermission";
    public static String SETTINGSPERMISSION = "settingspermission";
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    private static AppSharedPreferences appSharedPreferences;
    private static String PAYMENTSTATUS = "payment_status";
    private static String PAYMENT_BTN_STATUS = "payment_btn_status";
    private static String ACCHOLDERNAME = "acc_holder_name";
    private static String ACCHOLDERNUMBER = "acc_holder_number";
    private static String ACCIFSCCODE = "acc_ifsc_code";
    private static String INSTAMOJO_ID = "instamojo_id";
    String TAG = "Appshared";

    private AppSharedPreferences() {
    }

    public synchronized static AppSharedPreferences getInstance(Context context) {
        try {
            preferences = context.getSharedPreferences("insta_bill_pos", Context.MODE_PRIVATE);
            editor = preferences.edit();
            if (appSharedPreferences == null)
                appSharedPreferences = new AppSharedPreferences();

        } catch (NullPointerException e) {
            Log.d("TAG", "getInstance: " + e.getMessage());

        }
        return appSharedPreferences;
    }

    public void clearData() {
        editor.clear();
        editor.commit();
    }

    public boolean getRoundOff() {
        return preferences.getBoolean(ROUND_OFF, false);
    }

    public void setRoundOff(boolean roundOff) {
        editor.putBoolean(ROUND_OFF, roundOff).apply();
    }

    public String getPaymentBtnStatus() {
        return preferences.getString(PAYMENT_BTN_STATUS, "");
    }

    public void setPaymentBtnStatus(String paymentBtnStatus) {
        editor.putString(PAYMENT_BTN_STATUS, paymentBtnStatus);
        editor.apply();
    }

    public String getREVENUEAMOUT() {
        return preferences.getString(REVENUEAMOUT, "");
    }

    public void setREVENUEAMOUT(String revenueamout) {
        editor.putString(REVENUEAMOUT, revenueamout);
        editor.apply();
    }

    public void setParentuser(String parentuser) {
        editor.putString(PARENT_USER, parentuser).apply();
    }

    public String getParentUser() {
        return preferences.getString(PARENT_USER, "");
    }

    public String getEXPENSESAMOUNT() {
        return preferences.getString(EXPENSESAMOUNT, "");
    }

    public void setEXPENSESAMOUNT(String expensesamout) {
        editor.putString(EXPENSESAMOUNT, expensesamout);
        editor.apply();
    }

    public boolean isLogin() {
        return preferences.getBoolean("isLogin", false);
    }

    public void setLogin(boolean login) {
        editor.putBoolean("isLogin", login);
        editor.apply();
    }

    public boolean isInvoiceShowView() {
        return preferences.getBoolean(INVOICEVIEW, false);
    }

    public void setInvoiceShowView(boolean isInvoiceShowView) {
        editor.putBoolean(INVOICEVIEW, isInvoiceShowView);
        editor.apply();
    }

    public void setLoginTime(String loginTime) {
        editor.putString(LOGINTIME, loginTime).apply();
    }

    public String getLogintTime() {
        return preferences.getString(LOGINTIME, "");
    }

    public String getCreditNoteFooter() {
        return preferences.getString(CREDIT_NOTE_FOOTER, "");
    }

    public void setCreditNoteFooter(String creditNoteFooter) {
        editor.putString(CREDIT_NOTE_FOOTER, creditNoteFooter);
        editor.apply();
    }

    public String getDebitNoteFooter() {
        return preferences.getString(DEBIT_NOTE_FOOTER, "");
    }

    public void setDebitNoteFooter(String debitNoteFooter) {
        editor.putString(DEBIT_NOTE_FOOTER, debitNoteFooter);
        editor.apply();
    }

    public String getCreditNotePdfHeader() {
        return preferences.getString(CREDIT_NOTE_PDF_HEADER, "");
    }

    public void setCreditNotePdfHeader(String creditNotePdfHeader) {
        editor.putString(CREDIT_NOTE_PDF_HEADER, creditNotePdfHeader);
        editor.apply();
    }

    public String getDebitNotePdfHeader() {
        return preferences.getString(DEBIT_NOTE_PDF_HEADER, "");
    }

    public void setDebitNotePdfHeader(String debitNotePdfHeader) {
        editor.putString(DEBIT_NOTE_PDF_HEADER, debitNotePdfHeader);
        editor.apply();
    }

    public boolean isQuoatationShowView() {
        return preferences.getBoolean(QUOATATIONVIEW, false);
    }

    public void setQuoatationShowView(boolean isQuoatationShowView) {
        editor.putBoolean(QUOATATIONVIEW, isQuoatationShowView);
        editor.apply();
    }

    public String getINVOICEMANUAL() {
        return preferences.getString(INVOICEMANUAL, "");
    }


    public void setINVOICEMANUAL(String invoicemanual) {
        editor.putString(INVOICEMANUAL, invoicemanual);
        editor.apply();
    }

    public String getCREDITNOTEMANUAL() {
        return preferences.getString(CREDITNOTEMANUAL, "");
    }

    public void setCREDITNOTEMANUAL(String creditnotemanual) {
        editor.putString(CREDITNOTEMANUAL, creditnotemanual).apply();
    }

    public String getDEBITNOTEMANUAL() {
        return preferences.getString(DEBITNOTEMANUAL, "");
    }

    public void setDEBITNOTEMANUAL(String debitnotemanual) {
        editor.putString(DEBITNOTEMANUAL, debitnotemanual).apply();
    }

    public String getQUOTATIONEMANUAL() {
        return preferences.getString(QUOTATIONEMANUAL, "");
    }

    public void setQUOTATIONEMANUAL(String quotationemanual) {
        editor.putString(QUOTATIONEMANUAL, quotationemanual);
        editor.apply();
    }

    public String getPOMANUAL() {
        return preferences.getString(POMANUAL, "");
    }

    public void setPOMANUAL(String pomanual) {
        editor.putString(POMANUAL, pomanual);
        editor.apply();
    }

    public boolean isProductShowView() {
        return preferences.getBoolean(PRODUCTVIEW, false);
    }

    public void setProductShowView(boolean productShowView) {
        editor.putBoolean(PRODUCTVIEW, productShowView);
        editor.apply();
    }

    public boolean getNAVIGATION() {
        return preferences.getBoolean(NAVIGATION, false);
    }

    public void setNAVIGATION(boolean navigation) {
        editor.putBoolean(NAVIGATION, navigation);
        editor.apply();
    }

    public void setSalepermission(int salepermission) {
        editor.putInt(SALESPERMISSION, salepermission).apply();
    }

    public void setPurchasePermission(int value) {
        editor.putInt(PURCHASESPERMISSION, value).apply();
    }

    public void setProductPermission(int value) {
        editor.putInt(PRODUCTRPERMISSION, value).apply();
    }

    public void setExpensesPermission(int value) {
        editor.putInt(EXPENSESSPERMISSION, value).apply();
    }

    public void setCustomerPermission(int value) {
        editor.putInt(CUSTOMERPERMISSION, value).apply();
    }

    public void setVendorPermission(int value) {
        editor.putInt(VENDORPERMISSION, value).apply();
    }

    public void setReportPermission(int value) {
        editor.putInt(REPORTPERMISSION, value).apply();
    }

    public void setSettingPermission(int value) {
        editor.putInt(SETTINGSPERMISSION, value).apply();
    }

    public void setInventoryPermission(int value) {
        editor.putInt(INVENTORYPERMISSION, value).apply();

    }

    public int getSalePermission() {
        return preferences.getInt(SALESPERMISSION, 15);
    }

    public int getPurchasePemission() {
        return preferences.getInt(PURCHASESPERMISSION, 15);
    }

    public int getExpensesPemission() {
        return preferences.getInt(EXPENSESSPERMISSION, 15);
    }

    public int getReportPemission() {
        return preferences.getInt(REPORTPERMISSION, 15);
    }

    public int getInvenotryPemission() {
        return preferences.getInt(INVENTORYPERMISSION, 15);
    }

    public int getCustomerPemission() {
        return preferences.getInt(CUSTOMERPERMISSION, 15);
    }

    public int getVendorPemission() {
        return preferences.getInt(VENDORPERMISSION, 15);
    }

    public int getSettingPemission() {
        return preferences.getInt(SETTINGSPERMISSION, 15);
    }

    public int getProductPemission() {
        return preferences.getInt(PRODUCTRPERMISSION, 15);
    }


    public boolean isPurchaseOrderShowView() {
        return preferences.getBoolean(PURCHASEORDERVIEW, false);
    }

    public void setPurchaseOrderShowView(boolean isPurchaseOrderShowView) {
        editor.putBoolean(PURCHASEORDERVIEW, isPurchaseOrderShowView);
        editor.apply();
    }

    public boolean isPurchaseShowView() {
        return preferences.getBoolean(PURCHASEVIEW, false);
    }

    public void setPurchaseShowView(boolean isPurchaseShowView) {
        editor.putBoolean(PURCHASEVIEW, isPurchaseShowView);
        editor.apply();
    }


    public boolean isDashBoardShowView() {
        return preferences.getBoolean(DASHBOARDVIEW, false);
    }

    public void setDashBoardShowView(boolean isDashBoardShowView) {
        editor.putBoolean(DASHBOARDVIEW, isDashBoardShowView);
        editor.apply();
    }

    public String getUserId() {
        return preferences.getString(USER_ID, "");
    }


    public void setUserId(String id) {
        editor.putString(USER_ID, id);
        editor.apply();
    }

    public String getPlanType() {
        return preferences.getString("plan_type", "");
    }

    public void setPlanType(String plan) {
        editor.putString("plan_type", plan);
        editor.apply();
    }

    public String getUserInstaId() {
        return preferences.getString("insta_id", "");
    }

    public void setUserInstaId(String instaId) {
        editor.putString("insta_id", instaId);
        editor.apply();
    }

    public String getPlanDuration() {
        return preferences.getString(PLAN_TIME, "");
    }

    public void setPlanDuration(String time) {
        editor.putString(PLAN_TIME, time);
        editor.apply();
    }

    public String getPackagePlan() {
        return preferences.getString(PACKAGE_PLAN, "");
    }

    public void setPackagePlan(String plan) {
        editor.putString(PACKAGE_PLAN, plan);
        editor.apply();
    }

    public String getPackageId() {
        return preferences.getString(PACKAGE_ID, "");
    }

    public void setPackageId(String packageid) {
        editor.putString(PACKAGE_ID, packageid);
        editor.apply();
    }

    public String getPlanPrice() {
        return preferences.getString(PLAN_PRICE, "");
    }

    public void setPlanPrice(String price) {
        editor.putString(PLAN_PRICE, price);
        editor.apply();
    }

    public boolean isFirstTimeLogin() {
        return preferences.getBoolean("app_flag", false);
    }

    public void setFirstTimeLogin(boolean value) {
        editor.putBoolean("app_flag", value);
        editor.apply();
    }


    public String getName() {
        return preferences.getString("name", "");
    }

    public void setName(String name) {
        editor.putString("name", name);
        editor.apply();
    }

    public String getEmailId() {
        return preferences.getString("emailId", "");
    }

    public void setEmailId(String emailId) {
        editor.putString("emailId", emailId);
        editor.apply();
    }

    public String getPassword() {
        return preferences.getString("password", "");
    }

    public void setPassword(String password) {
        editor.putString("password", password);
        editor.apply();
    }

    public String getPhoneNo() {
        return preferences.getString("phoneNo", "");
    }

    public void setPhoneNo(String id) {
        editor.putString("phoneNo", id);
        editor.apply();
    }

    public String getAddress() {
        return preferences.getString("address", "");
    }

    public void setAddress(String address) {
        editor.putString("address", address);
        editor.apply();
    }

    public String getPAYMENTSTATUS() {
        return preferences.getString(PAYMENTSTATUS, "");
    }

    public void setPAYMENTSTATUS(String payStatus) {
        editor.putString(PAYMENTSTATUS, payStatus);
        editor.apply();
    }

    public String getACCHOLDERNAME() {
        return preferences.getString(ACCHOLDERNAME, "");
    }

    public void setACCHOLDERNAME(String accHolderName) {
        editor.putString(ACCHOLDERNAME, accHolderName);
        editor.apply();
    }

    public String getACCHOLDERNUMBER() {
        return preferences.getString(ACCHOLDERNUMBER, "");
    }

    public void setACCHOLDERNUMBER(String accNumber) {
        editor.putString(ACCHOLDERNUMBER, accNumber);
        editor.apply();
    }

    public String getACCIFSCCODE() {
        return preferences.getString(ACCIFSCCODE, "");
    }

    public void setACCIFSCCODE(String accIfsc) {
        editor.putString(ACCIFSCCODE, accIfsc);
        editor.apply();
    }

    public String getInstamojoId() {
        return preferences.getString(INSTAMOJO_ID, "");
    }

    public void setInstamojoId(String instamojoId) {
        editor.putString(INSTAMOJO_ID, instamojoId);
        editor.apply();
    }

    public String getUserType() {
        return preferences.getString("userType", "");
    }

    public void setUserType(String userType) {
        editor.putString("userType", userType);
        editor.apply();
    }

    public String getImage() {
        return preferences.getString("image", "");
    }

    public void setImage(String image) {
        editor.putString("image", image);
        editor.apply();
    }

    public boolean getNotification() {
        return preferences.getBoolean("notification", true);
    }

    public void setNotification(boolean notification) {
        editor.putBoolean("notification", notification);
        editor.apply();
    }

    public void syncContact(boolean sync) {
        editor.putBoolean("sync_contact", sync);
        editor.apply();
    }

    public boolean isContactSync() {
        return preferences.getBoolean("sync_contact", false);
    }

    public String getCompanyName() {
        return preferences.getString("company_name", "Company Name");
    }

    /*company data*/
    public void setCompanyName(String name) {
        editor.putString("company_name", name);
        editor.apply();
    }

    public String getCompanyId() {
        return preferences.getString("company_id", "");
    }

    public void setCompanyId(String id) {
        editor.putString("company_id", id);
        editor.apply();
    }

    public String getCompanyImage() {
        return preferences.getString("company_image", "");
    }

    public void setCompanyImage(String image) {
        editor.putString("company_image", image);
        editor.apply();
    }

    public String getCompanyGstin() {
        return preferences.getString("company_gsting", "");
    }

    public void setCompanyGstin(String gstin) {
        editor.putString("company_gsting", gstin);
        editor.apply();
    }

    public Boolean getCompanyCompositionValue() {
        return preferences.getBoolean("company_composition", false);
    }

    public void setCompanyCompositionValue(Boolean compositionValue) {
        editor.putBoolean("company_composition", compositionValue);
        editor.apply();
    }

    public String getCompanySupplyCode() {
        return preferences.getString("supplyCode", "");
    }

    public void setCompanySupplyCode(String supplyCode) {
        editor.putString("supplyCode", supplyCode);
        editor.apply();
    }

    public String getCompanyMobile() {
        return preferences.getString("mobile", "");
    }

    public void setCompanyMobile(String mobile) {
        editor.putString("mobile", mobile);
        editor.commit();
    }

    public String getFooter() {
        return preferences.getString("footer_text", "");
    }

    public void setFooter(String footer) {
        editor.putString("footer_text", footer);
        editor.apply();
    }

    public String getBankDetails() {
        return preferences.getString("bank_details", "");
    }

    public void setBankDetails(String footer) {
        editor.putString("bank_details", footer);
        editor.apply();
    }

    public String getInvoicePdfHeader() {
        return preferences.getString("inv_pdf_header", "");
    }

    public void setInvoicePdfHeader(String footer) {
        editor.putString("inv_pdf_header", footer);
        editor.apply();
    }

    public String getQuotationPdfHeader() {
        return preferences.getString("quo_pdf_header", "");
    }

    public void setQuotationPdfHeader(String footer) {
        editor.putString("quo_pdf_header", footer);
        editor.apply();
    }


    public String getPorderPdfHeader() {
        return preferences.getString("porder_pdf_header", "");
    }

    public void setPorderPdfHeader(String footer) {
        editor.putString("porder_pdf_header", footer);
        editor.apply();
    }

    public String getPurchaseFooter() {
        return preferences.getString("p_footer_text", "");
    }

    public void setPurchaseFooter(String footer) {
        editor.putString("p_footer_text", footer);
        editor.apply();
    }


    public String getQuotFooter() {
        return preferences.getString("quot_footer_text", "");
    }

    public void setQuotFooter(String footer) {
        editor.putString("quot_footer_text", footer);
        editor.apply();
    }

    public void saveAmount(float amount) {
        editor.putFloat("wallet_amount", amount);
        editor.apply();
    }

    public float getAmount() {
        return preferences.getFloat("wallet_amount", 0);
    }

    public String getExpiryDate() {
        return preferences.getString("expiry_date", "");
    }

    public void setExpiryDate(String date) {
        editor.putString("expiry_date", date);
        editor.apply();
    }

    public String getCreditNotePrefix() {
        return preferences.getString(CREDIT_NOTE_PREFIX, "");
    }

    public void setCreditNotePrefix(String prefix) {
        editor.putString(CREDIT_NOTE_PREFIX, prefix);
        editor.apply();
    }

    public String getDebitNotePrefix() {
        return preferences.getString(DEBIT_NOTE_PREFIX, "");
    }

    public void setDebitNotePrefix(String prefix) {
        editor.putString(DEBIT_NOTE_PREFIX, prefix);
        editor.apply();
    }

    public String getInvoicePrefix() {
        return preferences.getString("prefix", "");
    }

    public void setInvoicePrefix(String prefix) {
        editor.putString("prefix", prefix);
        editor.apply();
    }

    public String getInvoiceNumber() {
        return preferences.getString("invoice_num", "");
    }

    public void setInvoiceNumber(String number) {
        editor.putString("invoice_num", number);
        editor.apply();
    }

    public String getQuotNumber() {
        return preferences.getString("quot_num", "");
    }

    public void setQuotNumber(String number) {
        editor.putString("quot_num", number);
        editor.apply();
    }

    public String getQuotPrefix() {
        return preferences.getString("quot_prefix", "");
    }

    public void setQuotPrefix(String prefix) {
        editor.putString("quot_prefix", prefix);
        editor.apply();
    }

    public String getPurchasePrefix() {
        return preferences.getString("purchase_prefix", "");
    }

    public void setPurchasePrefix(String prefix) {
        editor.putString("purchase_prefix", prefix);
        editor.apply();
    }

    public String getPurchaseNumber() {
        return preferences.getString("purchase_num", "");
    }

    public void setPurchaseNumber(String number) {
        editor.putString("purchase_num", number);
        editor.apply();
    }

    public boolean isGSTAvail() {
        String gst = preferences.getString("company_gsting", "");
        return !gst.isEmpty();
    }


    public void setInvoiceTDS(boolean isActive) {
        editor.putBoolean("invoice_tds", isActive);
        editor.apply();
    }

    public boolean isInvoiceTDSActive() {
        return preferences.getBoolean("invoice_tds", false);
    }

    public void setQuoationTDS(boolean isActive) {
        editor.putBoolean("quo_tds", isActive);
        editor.apply();
    }

    public boolean isQuotationTDSActive() {
        return preferences.getBoolean("quo_tds", false);
    }


    public void setInvoiceDeliveryDetails(boolean isActive) {
        editor.putBoolean("inv_delivery_details", isActive);
        editor.apply();
    }

    public boolean isInvoiceDeliveryDetailsActive() {
        return preferences.getBoolean("inv_delivery_details", false);
    }


    public void setQuotationDeliveryDetails(boolean isActive) {
        editor.putBoolean("quo_delivery_details", isActive);
        editor.apply();
    }

    public boolean isQuotationDeliveryDetailsActive() {
        return preferences.getBoolean("quo_delivery_details", false);
    }

    public void setInvoicePorderDetails(boolean isActive) {
        editor.putBoolean("inv_porder_details", isActive);
        editor.apply();
    }


    public boolean isInvoicePorderDetailsActive() {
        return preferences.getBoolean("inv_porder_details", false);
    }


    public void setQuotationPorderDetails(boolean isActive) {
        editor.putBoolean("quo_porder_details", isActive);
        editor.apply();
    }

    public boolean isQuotationPorderDetailsActive() {
        return preferences.getBoolean("quo_porder_details", false);
    }


    public void setShippingCharge(boolean isActive) {
        editor.putBoolean("shipping", isActive);
        editor.apply();
    }

    public boolean isShippingActive() {
        return preferences.getBoolean("shipping", false);
    }

    public void setInventoryStatus(boolean isActive) {
        editor.putBoolean("inventory", isActive);
        editor.apply();
    }

    public boolean isInventoryActive() {
        return preferences.getBoolean("inventory", false);
    }

    public void setCess(boolean isActive) {
        editor.putBoolean("cess", isActive);
        editor.apply();
    }

    public boolean isCessActive() {
        return preferences.getBoolean("cess", false);
    }

    public void setProductQtyUnit(String unitid) {
        editor.putString("qty_unit_id", unitid);
        editor.apply();
    }

    public String getQtyUnitId() {
        return preferences.getString("qty_unit_id", "");
    }

    public int getLoginWith() {
        return preferences.getInt("login_with", 0);
    }

    public void setLoginWith(int loginwith) {
        editor.putInt("login_with", loginwith);
        editor.apply();
    }

    public String getBankID() {
        return preferences.getString("BankID", "");
    }

    public void setBankID(String BankID) {
        editor.putString("BankID", BankID);
        editor.apply();
    }

    public String getBankAccount() {
        return preferences.getString("BankAccount", "");
    }

    public void setBankAccount(String BankAccount) {
        editor.putString("BankAccount", BankAccount);
        editor.apply();
    }

    public String getTempOne() {
        return preferences.getString("temp_one", "");
    }

    public void setTempOne(String temp_one) {
        editor.putString("temp_one", temp_one);
        editor.apply();
    }

    public String getTempTwo() {
        return preferences.getString("temp_two", "");
    }

    public void setTempTwo(String temp_two) {
        editor.putString("temp_two", temp_two);
        editor.apply();
    }

    public String getDefaultLanguage() {
        return preferences.getString("lang", "");
    }

    public void setDefaultLanguage(String lang) {
        editor.putString("lang", lang);
        editor.apply();
    }

    public int getCounter() {
        return preferences.getInt("count", 0);
    }

    public void setCounter(int count) {
        editor.putInt("count", count);
        editor.apply();
    }

    public String getPaymentFlag() {
        return preferences.getString("paymentStatus", "0");
    }

    public void setPaymentFlag(String paymentStatus) {
        editor.putString("paymentStatus", paymentStatus);
        editor.apply();
    }

    public String getTodayDay() {
        return preferences.getString("todayday", "0");
    }

    public void setTodayDay(String todayday) {
        editor.putString("todayday", todayday);
        editor.apply();
    }

    public String getReferedUser() {
        return preferences.getString("referedUser", "");
    }

    public void setReferedUser(String referedUser) {
        editor.putString("referedUser", referedUser);
        editor.apply();
    }

    public String getBusinessType() {
        return preferences.getString("business_type", "");
    }

    public void setBusinessType(String business_type) {
        editor.putString("business_type", business_type);
        editor.apply();
    }
    public boolean isInclusive() {
        return preferences.getBoolean("inclusive", false);
    }

    public void setInclusive(boolean isActive) {
        editor.putBoolean("inclusive", isActive);
        editor.apply();
    }

}
