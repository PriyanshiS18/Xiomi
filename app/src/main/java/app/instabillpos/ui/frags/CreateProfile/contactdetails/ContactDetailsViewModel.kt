package app.instabillpos.ui.frags.CreateProfile.contactdetails

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.mProguard.Model.CreateProfileRes
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.repository.utils.Resource
import java.io.File

class ContactDetailsViewModel @ViewModelInject constructor(
    private val repository: mRepository
) : ViewModel() {
    suspend fun addCompany(
        userId: String, phone: String, email: String, companyName: String,
        deviceId: String, gstin: String, address: String, compositeScheme: String,
        pincode: String, cinNumber: String, pancard: String, website: String,
        license: String, licensenumber: String, logoPath: String, imagestatus: String,
        businessType: String, entity_type: String
    ): Resource<CreateProfileRes> {
        return repository.addCompany(
            userId, phone, email, companyName,
            deviceId, gstin, address, compositeScheme,
            pincode, cinNumber, pancard, website,
            license, licensenumber, logoPath, imagestatus,
            businessType, entity_type
        )
    }
}