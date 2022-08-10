package app.instabillpos.ui.frags.modeofpayment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.mProguard.Model.CreateOrder
import app.instabillpos.mProguard.Model.CreateOrderr
import app.instabillpos.mProguard.Model.InvoiceNumberModel
import app.instabillpos.mProguard.Model.createInvoiceResponseModel
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.repository.utils.Resource

class ModeOfPaymentViewModel @ViewModelInject constructor(
    private val repository: mRepository
) : ViewModel() {


    suspend fun getInvoiceNumber(): Resource<InvoiceNumberModel> {
        return repository.getInvoiceNumber()
    }

    suspend fun createInvoice(req: CreateOrderr): Resource<createInvoiceResponseModel> {
        return repository.createInvoice(req)
    }

    suspend fun createOfflineInvoice(req: CreateOrderr) {
        return repository.createOfflineInvoice(req)
    }
    suspend fun deleteEntryFromOfflineDatabase(offlineInvoiceID: CreateOrderr) {
        repository.deleteEntryFromOfflineDatabase(offlineInvoiceID)
    }

}