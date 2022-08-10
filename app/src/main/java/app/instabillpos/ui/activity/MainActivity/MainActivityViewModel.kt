package app.instabillpos.ui.activity.MainActivity

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.mProguard.Model.CreateOrderr
import app.instabillpos.mProguard.Model.InvoiceNumberModel
import app.instabillpos.mProguard.Model.createInvoiceResponseModel
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.repository.utils.Resource

class MainActivityViewModel @ViewModelInject constructor(
    private val repository: mRepository
) : ViewModel() {

    val products = repository.getProducts()
    val invoice = repository.getOfflineInvoice()

    suspend fun getInvoiceNumber(): Resource<InvoiceNumberModel> {
        return repository.getInvoiceNumber()
    }
    suspend fun createInvoice(req: CreateOrderr): Resource<createInvoiceResponseModel> {
        return repository.createInvoice(req)
    }
    suspend fun editInvoice(req: CreateOrderr): Resource<createInvoiceResponseModel> {
        return repository.editInvoice(req)
    }

    suspend fun deleteEntryFromOfflineDatabase(offlineInvoiceID: CreateOrderr) {
        repository.deleteEntryFromOfflineDatabase(offlineInvoiceID)
    }

}