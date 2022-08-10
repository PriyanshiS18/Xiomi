package app.instabillpos.ui.frags.CreateProfile.companyProfile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.mProguard.Model.GstDetailResponse
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.repository.utils.Resource

class CompanyProfileViewModel @ViewModelInject constructor(
    private val repository: mRepository
) : ViewModel() {
    suspend fun fetchGSTUserData(gstIN: String): Resource<GstDetailResponse> {
        return repository.fetchGSTUserData(gstIN)
    }
}