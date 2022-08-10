package app.instabillpos.ui.frags.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.mProguard.Model.LoginModel
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.repository.utils.Resource

class LoginViewModel @ViewModelInject constructor(
    private val repository: mRepository
) : ViewModel() {
    suspend fun loginUser(email: String, password: String, devceID: String): Resource<LoginModel> {
        return repository.loginUser(email, password, devceID)
    }
}