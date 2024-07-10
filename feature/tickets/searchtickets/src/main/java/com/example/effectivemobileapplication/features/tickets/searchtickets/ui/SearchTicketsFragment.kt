package com.example.effectivemobileapplication.features.tickets.searchtickets.ui

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.view.WindowId
import android.view.WindowId.FocusObserver
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.effectivemobileapplication.features.tickets.searchtickets.R
import com.example.effectivemobileapplication.features.tickets.searchtickets.databinding.FragmentSearchTicketsBinding
import com.example.effectivemobileapplication.features.tickets.searchtickets.di.SearchTicketsProvider
import com.example.effectivemobileapplication.features.tickets.searchtickets.presentation.SearchTicketsViewModel
import com.example.effectivemobileapplication.shared.tickets.core.ViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.search.SearchView.Behavior
import javax.inject.Inject


class SearchTicketsFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentSearchTicketsBinding? = null
    private val binding: FragmentSearchTicketsBinding
        get() = _binding ?: throw RuntimeException("Binding is null")

    private lateinit var cityName: String

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        (requireActivity().application as SearchTicketsProvider)
            .provideSearchTicketsComponent()
            .inject(this)
        super.onAttach(context)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().getString(CITY_NAME)?.let {
            cityName = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etDeparture.setText(cityName)
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[SearchTicketsViewModel::class.java]

        binding.ivClose.setOnClickListener {
            binding.etArrival.text?.clear()
        }


        binding.etArrival.setOnEditorActionListener(object : OnEditorActionListener {
            override fun onEditorAction(p0: TextView, p1: Int, p2: KeyEvent?): Boolean {
                if (p1 == EditorInfo.IME_ACTION_DONE&&p0.text.isNotEmpty()) {
                    viewModel.navigate(
                        binding.etDeparture.text.toString(),
                        binding.etArrival.text.toString()
                    )
                    return true
                }
                return false
            }
        })

        binding.etDeparture.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().matches("[a-zA-Z0-9]".toRegex())){
                    Toast.makeText(requireContext(),"Только русские буквы",Toast.LENGTH_SHORT).show()
                    binding.etArrival.text?.clear()

                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.etArrival.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().matches("[a-zA-Z0-9]".toRegex())){
                    Toast.makeText(requireContext(),"Только русские буквы",Toast.LENGTH_SHORT).show()
                    binding.etArrival.text?.clear()

                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })



        binding.lrHardRoute.setOnClickListener {
            viewModel.openHardRoute()
        }

        binding.lrTicketsFree.setOnClickListener {
            viewModel.openFireTickets()
        }

        binding.lrWeekends.setOnClickListener {
            viewModel.openWeekends()
        }


        binding.lrAnyWhere.setOnClickListener {
            binding.etArrival.setText("Турция")
        }

        binding.tvSochi.setOnClickListener{
            binding.etArrival.setText("Сочи")
        }
        binding.tvPhuket.setOnClickListener {
            binding.etArrival.setText("Пхукет")
        }
        binding.tvStambul.setOnClickListener {
            binding.etArrival.setText("Стамбул")
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    companion object {
        const val CITY_NAME = "city_name"
        fun newInstance(cityName: String): BottomSheetDialogFragment =
            SearchTicketsFragment().apply {
                arguments = Bundle().apply {
                    putString(CITY_NAME, cityName)
                }
            }
    }
}