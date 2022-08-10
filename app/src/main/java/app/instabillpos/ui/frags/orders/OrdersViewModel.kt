package app.instabillpos.ui.frags.orders


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.mProguard.Model.getInvoiceListModel
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.repository.utils.Resource

class OrdersViewModel @ViewModelInject constructor(
    private val repository: mRepository
) : ViewModel() {

    suspend fun getInvoiceList(
        offsetValue: String,
        limitValue: String
    ): Resource<getInvoiceListModel> {
        return repository.getInvoiceList(offsetValue, limitValue)
    }

    suspend fun getInvoiceList(search: String): Resource<getInvoiceListModel> {
        return repository.getInvoiceList(search)
    }
}