package com.example.effectivemobileapplication.features.tickets.ticketstocountry.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.R
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.adapter.TicketsAdapter
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.databinding.FragmentTicketsCountryBinding
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.di.TicketsToCountryProvider
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.presentation.TicketsOffersViewModel
import com.example.effectivemobileapplication.shared.tickets.core.ViewModelFactory
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class TicketsCountryFragment : Fragment() {


    private var _binding: FragmentTicketsCountryBinding? = null
    private val binding: FragmentTicketsCountryBinding
        get() = _binding ?: throw RuntimeException("Binding is null")

    private lateinit var cityDeparture: String
    private lateinit var cityArrive: String

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        (requireActivity().application as TicketsToCountryProvider)
            .provideTicketsToCountryComponent()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().getString(CITY_DEPARTURE_KEY)?.let {
            cityDeparture = it
        }
        requireArguments().getString(CITY_ARRIVE_KEY)?.let {
            cityArrive = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketsCountryBinding.inflate(inflater, container, false)
        binding.tvDatePicker.text = parseDate(LocalDateTime.now())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TicketsAdapter()
        binding.rvTickets.adapter = adapter
        binding.tvArrive.text = cityArrive
        binding.tvDeparture.text = cityDeparture
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[TicketsOffersViewModel::class.java]
        lifecycleScope.launch {
            viewModel.tickets.collect {
                adapter.submitList(it)
            }
        }
        binding.ivBack.setOnClickListener {
            viewModel.exit()
        }
        binding.ivSwap.setOnClickListener {
            val temp = binding.tvArrive.text.toString()
            binding.tvArrive.text = binding.tvDeparture.text
            binding.tvDeparture.text = temp
        }
        binding.ivClear.setOnClickListener {
            binding.tvArrive.text=""
        }
        binding.buttonAllTickets.setOnClickListener {
            val cityDeparture = binding.tvDeparture.text.toString()
            val cityArrive = binding.tvArrive.text.toString()
            val date = binding.tvDatePicker.text.toString()
            viewModel.navigateToAllTickets(cityDeparture, cityArrive, date)
        }




        binding.cvDateArrive.setOnClickListener {
            val builder: MaterialDatePicker.Builder<Long> = MaterialDatePicker.Builder.datePicker()
            val picker: MaterialDatePicker<Long> = builder.build()
            picker.show(childFragmentManager, picker.toString())
            picker.addOnPositiveButtonClickListener {
                val utc=Calendar.getInstance(TimeZone.getDefault())
                utc.timeInMillis=it
                val format=SimpleDateFormat("dd MMMM, EEE", Locale.getDefault())
                binding.tvDatePicker.text=format.format(utc.time)
            }
        }


    }

    fun parseDate(date: LocalDateTime): String {
        val parsed = DateTimeFormatter.ofPattern("dd")
        val parsedMonth=DateTimeFormatter.ofPattern("EEE")
        val day = date.format(parsed)
        val dayOfWeek=date.format(parsedMonth)
        val month=date.month.toString().lowercase()
        return StringBuilder("$day $month, $dayOfWeek").toString()
    }


    companion object {

        private const val CITY_DEPARTURE_KEY = "departure"
        private const val CITY_ARRIVE_KEY = "arrive"

        fun newInstance(cityDeparture: String, cityArrive: String) =
            TicketsCountryFragment().apply {
                arguments = Bundle().apply {
                    putString(CITY_DEPARTURE_KEY, cityDeparture)
                    putString(CITY_ARRIVE_KEY, cityArrive)
                }
            }
    }
}