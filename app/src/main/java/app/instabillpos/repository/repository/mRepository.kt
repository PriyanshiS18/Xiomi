package app.instabillpos.repository.repository


import app.instabillpos.mProguard.Model.CreateOrderr
import app.instabillpos.repository.local.products.ProductDao
import app.instabillpos.repository.remote.mRemoteDataSource
import app.instabillpos.repository.utils.performGetOperation
import javax.inject.Inject

class mRepository @Inject constructor(
    private val remoteDataSource: mRemoteDataSource,
    private val localDataSource: ProductDao
) {

    fun getProducts() = performGetOperation(
        databaseQuery = { localDataSource.getAllProducts() },
        networkCall = { remoteDataSource.getProducts() },
        saveCallResult = { localDataSource.insertAll(it.data) }
    )

    suspend fun loginUser(email: String, password: String, devceID: String) =
        remoteDataSource.loginUser(email, password, devceID)

    suspend fun register(
        name: String,
        phone: String,
        password: String,
        email: String,
        devceID: String
    ) =
        remoteDataSource.register(name, phone, password, email, devceID)


    suspend fun fetchGSTUserData(
        gstIN: String
    ) =
        remoteDataSource.fetchGSTUserData(gstIN)

    suspend fun addCompany(
        userId: String, phone: String, email: String, companyName: String,
        deviceId: String, gstin: String, address: String, compositeScheme: String,
        pincode: String, cinNumber: String, pancard: String, website: String,
        license: String, licensenumber: String, logoPath: String, imagestatus: String,
        businessType: String, entity_type: String
    ) =
        remoteDataSource.addCompany(
            userId, phone, email, companyName,
            deviceId, gstin, address, compositeScheme,
            pincode, cinNumber, pancard, website,
            license, licensenumber, logoPath, imagestatus,
            businessType, entity_type
        )

    suspend fun getCustomerDetail(mobile: String) =
        remoteDataSource.getCustomerDetail(mobile)

    suspend fun addCustomer(
        companyName: String,
        name: String,
        address: String,
        number: String,
        email: String,
        city: String,
        pinCode: String,
        state: String
    ) =
        remoteDataSource.addCustomer(
            companyName,
            name,
            address,
            number,
            email,
            city,
            pinCode,
            state
        )

    suspend fun editCustomer(
        customerId: String,
        companyName: String,
        name: String,
        address: String,
        number: String,
        email: String,
        city: String,
        pinCode: String,
        state: String
    ) =
        remoteDataSource.editCustomer(
            customerId,
            companyName,
            name,
            address,
            number,
            email,
            city,
            pinCode,
            state
        )


    suspend fun getState() =
        remoteDataSource.getState()

    suspend fun fetchGSTData(gstNumber: String) =
        remoteDataSource.fetchGSTData(gstNumber)

    suspend fun getInvoiceNumber() =
        remoteDataSource.getInvoiceNumber()



    suspend fun createInvoice(req: CreateOrderr) =
        remoteDataSource.createInvoice(req)
 suspend fun editInvoice(req: CreateOrderr) =
        remoteDataSource.editInvoice(req)

    suspend fun createOfflineInvoice(req: CreateOrderr) =
        localDataSource.insertInvoice(req)

    fun getOfflineInvoice() =
        localDataSource.getOfflineInvoice()

    suspend fun deleteEntryFromOfflineDatabase(req: CreateOrderr) =
        localDataSource.deleteOfflineInvoice(req)


    suspend fun getCustomer() =
        remoteDataSource.getCustomer()

    suspend fun getInvoiceList(offsetValue:String,limitValue:String) =
        remoteDataSource.getInvoiceList(offsetValue,limitValue)

    suspend fun getInvoiceList(search: String) =
        remoteDataSource.getInvoiceList(search)
}