package app.instabillpos.mProguard.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginModel {

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

        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("packages_id")
        @Expose
        private String packagesId;
        @SerializedName("package_plan")
        @Expose
        private String packagePlan;
        @SerializedName("expire_date")
        @Expose
        private String expireDate;
        @SerializedName("login_with")
        @Expose
        private String loginWith;
        @SerializedName("login_time")
        @Expose
        private String loginTime;
        @SerializedName("user_phone")
        @Expose
        private String userPhone;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("device_token")
        @Expose
        private String deviceToken;
        @SerializedName("device_type")
        @Expose
        private String deviceType;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("company_logo")
        @Expose
        private String companyLogo;
        @SerializedName("company_name")
        @Expose
        private String companyName;
        @SerializedName("company_gstin")
        @Expose
        private String companyGstin;
        @SerializedName("gst_composite_scheme")
        @Expose
        private String gstCompositeScheme;
        @SerializedName("company_address")
        @Expose
        private String companyAddress;
        @SerializedName("inventory_status")
        @Expose
        private String inventoryStatus;

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

        public String getPackagesId() {
            return packagesId;
        }

        public void setPackagesId(String packagesId) {
            this.packagesId = packagesId;
        }

        public String getPackagePlan() {
            return packagePlan;
        }

        public void setPackagePlan(String packagePlan) {
            this.packagePlan = packagePlan;
        }

        public String getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(String expireDate) {
            this.expireDate = expireDate;
        }

        public String getLoginWith() {
            return loginWith;
        }

        public void setLoginWith(String loginWith) {
            this.loginWith = loginWith;
        }

        public String getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(String loginTime) {
            this.loginTime = loginTime;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(String deviceToken) {
            this.deviceToken = deviceToken;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
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

        public String getGstCompositeScheme() {
            return gstCompositeScheme;
        }

        public void setGstCompositeScheme(String gstCompositeScheme) {
            this.gstCompositeScheme = gstCompositeScheme;
        }

        public String getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
        }

        public String getInventoryStatus() {
            return inventoryStatus;
        }

        public void setInventoryStatus(String inventoryStatus) {
            this.inventoryStatus = inventoryStatus;
        }

    }
}
