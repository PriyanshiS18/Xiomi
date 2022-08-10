package app.instabillpos.ui.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.instabillpos.databinding.CartBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Cart : BottomSheetDialogFragment() {

    private var _binding: CartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CartBinding.inflate(inflater, container, false)
        return binding.root
    }
}