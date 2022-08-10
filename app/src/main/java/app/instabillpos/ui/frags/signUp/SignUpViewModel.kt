package app.instabillpos.ui.frags.signUp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.mProguard.Model.LoginModel
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.repository.utils.Resource

class SignUpViewModel @ViewModelInject constructor(
    private val repository: mRepository
) : ViewModel() {
    suspend fun register(
        name: String,
        phone: String,
        password: String,
        email: String,
        devceID: String
    ): Resource<LoginModel> {
        return repository.register(name, phone, password, email, devceID)
    }
}