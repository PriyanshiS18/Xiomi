package app.instabillpos.mProguard.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CreateProfileRes {
    @SerializedName("email")
    private String email;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("errorCode")
    @Expose
    private String errorCode;
    @SerializedName("errorMsg")
    @Expose
    private String errorMsg;
    @SerializedName("company_id")
    @Expose
    private String companyId;
    @SerializedName("company_logo")
    @Expose
    private String companyLogo;
    @SerializedName("company_name")
    @Expose
    private String companyName;

    @SerializedName("gst_composite_scheme")
    @Expose
    private String compostionValue;

    @SerializedName("company_gstin")
    @Expose
    private String companyGstin;
    @SerializedName("data")
    @Expose


    private List<Object> data = null;

    public String getCompostionValue() {
        return compostionValue;
    }

    public void setCompostionValue(String compostionValue) {
        this.compostionValue = compostionValue;
    }

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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyGstin() {
        return companyGstin;
    }

    public void setCompanyGstin(String companyGstin) {
        this.companyGstin = companyGstin;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

