package app.instabillpos.repository.remote

import android.net.Uri
import app.instabillpos.mProguard.Model.CreateOrderr
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

class mRemoteDataSource @Inject constructor(
    private val APIService: APIService,
    private val sharedPreferences: AppSharedPreferences
) : BaseDataSource() {


    suspend fun getProducts() = getResult {
        APIService.getAllProducts(
            sharedPreferences.userId,
            sharedPreferences.companyId
        )
    }

    suspend fun getCustomerDetail(number: String) = getResult {
        APIService.getCustomerDetail(
            sharedPreferences.userId,
            sharedPreferences.companyId,
            number
        )
    }

    suspend fun loginUser(email: String, password: String, devceID: String) = getResult {
        APIService.login(email, password, devceID, "android", "android")
    }

    suspend fun register(
        name: String,
        phone: String,
        password: String,
        email: String,
        devceID: String
    ) = getResult {
        APIService.register("android", name, phone, password, email, devceID)

    }

    suspend fun fetchGSTUserData(
        gstIN: String
    ) = getResult {
        APIService.fetchGSTUserData(gstIN)

    }

    suspend fun addCompany(
        userId: String, phone: String, email: String, companyName: String,
        deviceId: String, gstin: String, address: String, compositeScheme: String,
        pincode: String, cinNumber: String, pancard: String, website: String,
        license: String, licensenumber: String, logoPath: String, imagestatus: String,
        businessType: String, entity_type: String
    ) = getResult {
        APIService.addNewCompany(
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), "android"),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), deviceId),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), userId),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), companyName),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), address),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), gstin),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), compositeScheme),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), email),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), phone),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), imagestatus),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), pincode),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), cinNumber),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), pancard),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), website),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), license),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), licensenumber),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), businessType),
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), entity_type),
            if (logoPath.length > 5) {
                MultipartBody.Part.createFormData(
                    "company_logo", File(Uri.parse(logoPath).path).name,
                    RequestBody.create(
                        "multipart/form-data".toMediaTypeOrNull(),
                        File(Uri.parse(logoPath).path)
                    )
                )
            } else {
                MultipartBody.Part.createFormData(
                    "company_logo", " ",
                    RequestBody.create(
                        "multipart/form-data".toMediaTypeOrNull(),
                        " "
                    )
                )

            }
        )
    }


    suspend fun addCustomer(
        companyName: String,
        name: String,
        address: String,
        number: String,
        email: String,
        city: String,
        pinCode: String,
        state: String
    ) = getResult {
        APIService.addCustomer(
            sharedPreferences.userId,
            sharedPreferences.companyId,
            companyName, name, address, number, email, city, pinCode, state
        )
    }

    suspend fun editCustomer(
        customerId: String,
        companyName: String,
        name: String,
        address: String,
        number: String,
        email: String,
        city: String,
        pinCode: String,
        state: String,
    ) = getResult {
        APIService.editCustomer(
            customerId,
            sharedPreferences.userId,
            sharedPreferences.companyId,
            companyName, name, address, number, email, city, pinCode, state
        )
    }

    suspend fun getState() = getResult {
        APIService.getState()
    }

    suspend fun fetchGSTData(gstNumber: String) = getResult {
        APIService.fetchGSTData(gstNumber)
    }

    suspend fun getInvoiceNumber() = getResult {
        APIService.getInvoiceNumber(
            sharedPreferences.userId,
            sharedPreferences.companyId
        )
    }

    suspend fun createInvoice(req: CreateOrderr) = getResult {
        APIService.createInvoice(
            req
        )
    }
 suspend fun editInvoice(req: CreateOrderr) = getResult {
        APIService.editInvoice(
            req
        )
    }

    suspend fun getCustomer() = getResult {
        APIService.getCustomer(
            sharedPreferences.userId,
            sharedPreferences.companyId
        )
    }

    suspend fun getInvoiceList(offsetValue:String,limitValue:String) = getResult {
        APIService.getInvoiceList(
            sharedPreferences.userId,
            sharedPreferences.companyId,
            offsetValue,
            limitValue
        )
    }
    suspend fun getInvoiceList(search: String) = getResult {
        APIService.getInvoiceList(
            sharedPreferences.userId,
            sharedPreferences.companyId,
            search
        )
    }


}