package app.instabillpos.repository.remote


import app.instabillpos.mProguard.Model.*
import app.instabillpos.repository.entities.products.AllProducts
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface APIService {
    @FormUrlEncoded
    @POST("get_product_test_new")
    suspend fun getAllProducts(
        @Field("userId") user_id: String,
        @Field("company_id") company_id: String
    ): Response<AllProducts>

    @FormUrlEncoded
    @POST("get_customer_detail")
    suspend fun getCustomerDetail(
        @Field("user_id") user_id: String,
        @Field("company_id") company_id: String,
        @Field("mobile") mobile: String
    ): Response<getCustomerDetailModel>


    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("device_token") device_token: String,
        @Field("device_type") device_type: String,
        @Field("deviceType") deviceType: String
    ): Response<LoginModel>


    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("device_type") device_type: String,
        @Field("name") name: String,
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("email") email: String,
        @Field("device_token") device_token: String
    ): Response<LoginModel>

    @FormUrlEncoded
    @POST("store_gstin")
    suspend fun fetchGSTUserData(
        @Field("gstin") device_type: String
    ): Response<GstDetailResponse>

    @Multipart
    @POST("add_company_test")
    suspend fun addNewCompany(
        @Part("device_type") device_type: RequestBody,
        @Part("device_token") device_token: RequestBody,
        @Part("userId") userId: RequestBody,
        @Part("company_name") company_name: RequestBody,
        @Part("address") address: RequestBody,
        @Part("gstin_text") gstin_text: RequestBody,
        @Part("gst_composite_scheme") gst_composite_scheme: RequestBody,
        @Part("email") email: RequestBody,
        @Part("mobile") mobile: RequestBody,
        @Part("image_status") imageStatus: RequestBody,
        @Part("pincode") pincode: RequestBody,
        @Part("cin") cinNumber: RequestBody,
        @Part("pan_card") pancard: RequestBody,
        @Part("website") website: RequestBody,
        @Part("license") license: RequestBody,
        @Part("license_number") licensenumber: RequestBody,
        @Part("business_type") business_type: RequestBody,
        @Part("entity_type") entity_type: RequestBody,
        @Part logo: MultipartBody.Part
    ): Response<CreateProfileRes>


    @FormUrlEncoded
    @POST("add_customer_test")
    suspend fun addCustomer(
        @Field("userId") user_id: String,
        @Field("company_id") company_id: String,
        @Field("company_name") company_name: String,
        @Field("name") name: String,
        @Field("address") address: String,
        @Field("mobile") mobile: String,
        @Field("email") email: String,
        @Field("city") city: String,
        @Field("pincode") pincode: String,
        @Field("state") state: String,
    ): Response<getCustomerDetailModel>


    @FormUrlEncoded
    @POST("edit_customer_test")
    suspend fun editCustomer(
        @Field("customer_id") customerId: String,
        @Field("userId") user_id: String,
        @Field("company_id") company_id: String,
        @Field("company_name") company_name: String,
        @Field("name") name: String,
        @Field("address") address: String,
        @Field("mobile") mobile: String,
        @Field("email") email: String,
        @Field("city") city: String,
        @Field("pincode") pincode: String,
        @Field("state") state: String,
    ): Response<getCustomerDetailModel>

    @GET("gst_code")
    suspend fun getState(): Response<StateRes>

    @FormUrlEncoded
    @POST("store_gstin")
    suspend fun fetchGSTData(@Field("gstin") gstin: String): Response<GSTJsonResponse>

    @FormUrlEncoded
    @POST("get_invoice_number")
    suspend fun getInvoiceNumber(
        @Field("userId") userId: String,
        @Field("company_id") company_id: String
    ): Response<InvoiceNumberModel>


    @POST("add_invoice4_test")
    suspend fun createInvoice(@Body req: CreateOrderr)
            : Response<createInvoiceResponseModel>

    @POST("edit_invoice4")
    suspend fun editInvoice(@Body req: CreateOrderr)
            : Response<createInvoiceResponseModel>

    @FormUrlEncoded
    @POST("get_customer")
    suspend fun getCustomer(
        @Field("userId") userId: String,
        @Field("company_id") company_id: String
    ): Response<CustomerListModel>


    @FormUrlEncoded
    @POST("get_invoice_test")
    suspend fun getInvoiceList(
        @Field("userId") userId: String,
        @Field("company_id") company_id: String,
        @Field("offset_value") offset_value: String,
        @Field("limit_value") limit_value: String,
    ): Response<getInvoiceListModel>

    @FormUrlEncoded
    @POST("get_invoice_test")
    suspend fun getInvoiceList(
        @Field("userId") userId: String,
        @Field("company_id") company_id: String,
        @Field("search_req") search: String,
    ): Response<getInvoiceListModel>


}