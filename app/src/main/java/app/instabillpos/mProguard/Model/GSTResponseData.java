package app.instabillpos.mProguard.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GSTResponseData {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("business_type")
    @Expose
    private String businessType;

    @SerializedName("entity_type")
    @Expose
    private String entityType;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @SerializedName("stjcd")
    @Expose
    private String StateJurisdictionCode;
    @SerializedName("dty")
    @Expose
    private String TaxpayerType;
    @SerializedName("lgnm")
    @Expose
    private String LegalNameOfBusiness;
    @SerializedName("stj")
    @Expose
    private String StateJurisdiction;
    @SerializedName("gstin")
    @Expose
    private String gstin;
    @SerializedName("nba")
    @Expose
    private String NatureofBusinessActivity;
    @SerializedName("lstupdt")
    @Expose
    private String lstupdt;
    @SerializedName("rgdt")
    @Expose
    private String DateOfRegistration;
    @SerializedName("ctb")
    @Expose
    private String ConstitutionOfBusiness;
    @SerializedName("bnm")
    @Expose
    private String BuildingName;
    @SerializedName("st")
    @Expose
    private String Street;
    @SerializedName("loc")
    @Expose
    private String location;
    @SerializedName("stcd")
    @Expose
    private String StateName;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("flno")
    @Expose
    private String floorNumber;
    @SerializedName("lt")
    @Expose
    private String lattitude;
    @SerializedName("addr")
    @Expose
    private String address;
    @SerializedName("pncd")
    @Expose
    private String pincode;
    @SerializedName("lg")
    @Expose
    private String longitude;
    @SerializedName("tradenam")
    @Expose
    private String tradeName;
    @SerializedName("ctjcd")
    @Expose
    private String CentreJurisdictionCode;
    @SerializedName("sts")
    @Expose
    private String GSTNstatus;
    @SerializedName("ctj")
    @Expose
    private String CentreJurisdiction;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStateJurisdictionCode() {
        return StateJurisdictionCode;
    }

    public void setStateJurisdictionCode(String stateJurisdictionCode) {
        StateJurisdictionCode = stateJurisdictionCode;
    }

    public String getTaxpayerType() {
        return TaxpayerType;
    }

    public void setTaxpayerType(String taxpayerType) {
        TaxpayerType = taxpayerType;
    }

    public String getLegalNameOfBusiness() {
        return LegalNameOfBusiness;
    }

    public void setLegalNameOfBusiness(String legalNameOfBusiness) {
        LegalNameOfBusiness = legalNameOfBusiness;
    }

    public String getStateJurisdiction() {
        return StateJurisdiction;
    }

    public void setStateJurisdiction(String stateJurisdiction) {
        StateJurisdiction = stateJurisdiction;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getNatureofBusinessActivity() {
        return NatureofBusinessActivity;
    }

    public void setNatureofBusinessActivity(String natureofBusinessActivity) {
        NatureofBusinessActivity = natureofBusinessActivity;
    }

    public String getLstupdt() {
        return lstupdt;
    }

    public void setLstupdt(String lstupdt) {
        this.lstupdt = lstupdt;
    }

    public String getDateOfRegistration() {
        return DateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        DateOfRegistration = dateOfRegistration;
    }

    public String getConstitutionOfBusiness() {
        return ConstitutionOfBusiness;
    }

    public void setConstitutionOfBusiness(String constitutionOfBusiness) {
        ConstitutionOfBusiness = constitutionOfBusiness;
    }

    public String getBuildingName() {
        return BuildingName;
    }

    public void setBuildingName(String buildingName) {
        BuildingName = buildingName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getCentreJurisdictionCode() {
        return CentreJurisdictionCode;
    }

    public void setCentreJurisdictionCode(String centreJurisdictionCode) {
        CentreJurisdictionCode = centreJurisdictionCode;
    }

    public String getGSTNstatus() {
        return GSTNstatus;
    }

    public void setGSTNstatus(String GSTNstatus) {
        this.GSTNstatus = GSTNstatus;
    }

    public String getCentreJurisdiction() {
        return CentreJurisdiction;
    }

    public void setCentreJurisdiction(String centreJurisdiction) {
        CentreJurisdiction = centreJurisdiction;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
