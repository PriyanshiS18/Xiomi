package app.instabillpos.ui.frags.customers

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.mProguard.Model.CustomerListModel
import app.instabillpos.mProguard.Model.StateRes
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.repository.utils.Resource

class CustomersViewModel @ViewModelInject constructor(
   private val repository: mRepository
) : ViewModel() {

    suspend fun getCustomer(): Resource<CustomerListModel> {
        return repository.getCustomer()
    }
}