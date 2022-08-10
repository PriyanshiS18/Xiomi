package app.instabillpos.ui.frags.contacydetails

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.mProguard.Model.GSTJsonResponse
import app.instabillpos.mProguard.Model.StateRes
import app.instabillpos.mProguard.Model.getCustomerDetailModel
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.repository.utils.Resource

class CustomerDetailsViewModel @ViewModelInject constructor(
    private val repository: mRepository
) : ViewModel() {


    suspend fun getCustomerDetail(mobile: String): Resource<getCustomerDetailModel> {
        return repository.getCustomerDetail(mobile)
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
    ): Resource<getCustomerDetailModel> {
        return repository.addCustomer(
            companyName,
            name,
            address,
            number,
            email,
            city,
            pinCode,
            state
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
        state: String
    ): Resource<getCustomerDetailModel> {
        return repository.editCustomer(
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
    }

    suspend fun getState(): Resource<StateRes> {
        return repository.getState()
    }

    suspend fun fetchGSTData(gstNumber: String): Resource<GSTJsonResponse> {
        return repository.fetchGSTData(gstNumber)
    }

}