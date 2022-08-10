package app.instabillpos.mProguard.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GSTJsonResponse {
    @SerializedName("data")
    @Expose
    private GSTResponseData data = null;
    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GSTResponseData getData() {
        return data;
    }

    public void setData(GSTResponseData data) {
        this.data = data;
    }


}
