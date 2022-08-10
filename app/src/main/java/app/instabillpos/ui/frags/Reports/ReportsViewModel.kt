package app.instabillpos.ui.frags.Reports

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import app.instabillpos.repository.repository.mRepository

class ReportsViewModel @ViewModelInject constructor(
    repository: mRepository
) : ViewModel() {}