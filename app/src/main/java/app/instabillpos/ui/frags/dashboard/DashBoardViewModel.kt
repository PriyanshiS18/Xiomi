package app.instabillpos.ui.frags.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.repository.repository.mRepository

class DashBoardViewModel  @ViewModelInject constructor(
    repository: mRepository
) : ViewModel() {

    val products = repository.getProducts()
}