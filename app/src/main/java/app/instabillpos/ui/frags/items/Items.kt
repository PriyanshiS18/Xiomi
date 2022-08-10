package app.instabillpos.ui.frags.items

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import app.instabillpos.R
import app.instabillpos.databinding.ItemsBinding
import app.instabillpos.repository.entities.products.Data
import app.instabillpos.repository.utils.Resource
import app.instabillpos.ui.frags.dashboard.DashBoardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Items : Fragment(), DashBoardAdapter.ItemListener, View.OnClickListener {

    private var _binding: ItemsBinding? = null
    private val bind get() = _binding!!

    private val viewModel: ItemsViewModel by viewModels()
    private lateinit var mAdapter: DashBoardAdapter

    var allResult = ArrayList<Data>()
    var searchedName = ""
    var searchResult = ArrayList<Data>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ItemsBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAllComponents()
        setUpRecyclerView()
        setupObservers()
        setUpSearch()
    }

    private fun initAllComponents() {
        bind.back.setOnClickListener(this)
    }


    private fun setUpRecyclerView() {
        mAdapter = DashBoardAdapter(requireContext(), this@Items)
        bind.productRecycler.layoutManager =
            GridLayoutManager(requireContext(), 6)
        bind.productRecycler.adapter = mAdapter
    }

    override fun addItemToCard(data: Data, editFlag: Boolean) {
        //
    }

    private fun setUpSearch() {
        bind.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                searchedName = s.toString().toLowerCase()
                searchResult.clear()
                for (i in 0 until allResult.size) {
                    if (allResult[i].name!!.toLowerCase().contains(searchedName)) {
                        searchResult.add(allResult[i])

                    }

                }

                if (count == 0) {
                    mAdapter.setItems(allResult)

                } else {
                    mAdapter.setItems(searchResult)
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })



        bind.search.setOnTouchListener(View.OnTouchListener { v, event ->
            val DRAWABLE_RIGHT = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= bind.search.right - bind.search.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                ) {
                    bind.search.setText("")
                    bind.searchContainer.visibility = View.GONE

                    return@OnTouchListener true
                }
            }
            false
        })

    }

    private fun setupObservers() {


        viewModel.products.observeForever {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) {
                        allResult = ArrayList(it.data)
                        mAdapter.setItems(allResult)
                    }
                }
                Resource.Status.ERROR -> {
                    Log.i("SANJAY", "setupObservers: ERROR  ${it.message}")
                    //Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }

                Resource.Status.LOADING -> {
                    Log.i("SANJAY", "setupObservers: LOADING")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back -> {
                requireView().findNavController().popBackStack()
            }
        }
    }
}