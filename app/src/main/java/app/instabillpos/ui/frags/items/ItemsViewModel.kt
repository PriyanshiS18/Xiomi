package app.instabillpos.ui.frags.items

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.repository.repository.mRepository

class ItemsViewModel @ViewModelInject constructor(
    repository: mRepository
) : ViewModel() {
    val products = repository.getProducts()
}