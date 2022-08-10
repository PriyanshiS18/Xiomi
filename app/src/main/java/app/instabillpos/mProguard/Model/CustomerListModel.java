package app.instabillpos.mProguard.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerListModel {

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
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("name")
        @Expose
        private Object name;
        @SerializedName("company_name")
        @Expose
        private String companyName;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("state")
        @Expose
        private Object state;
        @SerializedName("city")
        @Expose
        private Object city;
        @SerializedName("pincode")
        @Expose
        private Object pincode;
        @SerializedName("gstin")
        @Expose
        private Object gstin;
        @SerializedName("place_supply")
        @Expose
        private Object placeSupply;
        @SerializedName("supply_code")
        @Expose
        private Object supplyCode;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("entity_type")
        @Expose
        private Object entityType;
        @SerializedName("title")
        @Expose
        private Object title;
        @SerializedName("detail")
        @Expose
        private Object detail;
        @SerializedName("import_id")
        @Expose
        private String importId;
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

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
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

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getPincode() {
            return pincode;
        }

        public void setPincode(Object pincode) {
            this.pincode = pincode;
        }

        public Object getGstin() {
            return gstin;
        }

        public void setGstin(Object gstin) {
            this.gstin = gstin;
        }

        public Object getPlaceSupply() {
            return placeSupply;
        }

        public void setPlaceSupply(Object placeSupply) {
            this.placeSupply = placeSupply;
        }

        public Object getSupplyCode() {
            return supplyCode;
        }

        public void setSupplyCode(Object supplyCode) {
            this.supplyCode = supplyCode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getEntityType() {
            return entityType;
        }

        public void setEntityType(Object entityType) {
            this.entityType = entityType;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public Object getDetail() {
            return detail;
        }

        public void setDetail(Object detail) {
            this.detail = detail;
        }

        public String getImportId() {
            return importId;
        }

        public void setImportId(String importId) {
            this.importId = importId;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

    }
}
