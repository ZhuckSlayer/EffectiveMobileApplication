package com.example.effectivemobileapplication.features.tickets.showtickets.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.effectivemobileapplication.features.tickets.showtickets.R
import com.example.effectivemobileapplication.features.tickets.showtickets.adapter.ShowTicketsAdapter
import com.example.effectivemobileapplication.features.tickets.showtickets.databinding.FragmentAllTicketsBinding
import com.example.effectivemobileapplication.features.tickets.showtickets.di.ShowTicketsProvider
import com.example.effectivemobileapplication.features.tickets.showtickets.presentation.TicketsViewModel
import com.example.effectivemobileapplication.shared.tickets.core.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


class AllTicketsFragment : Fragment() {

    private var _binding: FragmentAllTicketsBinding? = null
    val binding: FragmentAllTicketsBinding
        get() = _binding ?: throw RuntimeException("Binding is null")

    private lateinit var cityDeparture: String
    private lateinit var cityArrive: String
    private lateinit var date: String

    @Inject
    lateinit var viewModelFactory: ViewModelFactory



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().getString(CITY_DEPARTURE_KEY)?.let {
            cityDeparture = it
        }
        requireArguments().getString(CITY_ARRIVE_KEY)?.let {
            cityArrive = it
        }
        requireArguments().getString(DATE_KEY)?.let {
            date = it
        }
    }

    override fun onAttach(context: Context) {
        (requireActivity().application as ShowTicketsProvider)
            .provideShowTicketsComponent()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ShowTicketsAdapter()
        binding.rvTickets.adapter = adapter
        val viewmodel = ViewModelProvider(this, viewModelFactory)[TicketsViewModel::class.java]
        lifecycleScope.launch {
            viewmodel.tickets.collect {
                adapter.submitList(it)
            }
        }
        binding.ivBack.setOnClickListener {
            viewmodel.close()
        }
        binding.tvDate.text = getString(R.string.date, date)
        binding.tvCities.text = getString(R.string.cities, cityDeparture, cityArrive)
    }

    companion object {

        private const val CITY_DEPARTURE_KEY = "departure"
        private const val CITY_ARRIVE_KEY = "arrive"
        private const val DATE_KEY = "date"


        fun newInstance(cityDeparture: String, cityArrive: String, date: String) =
            AllTicketsFragment().apply {
                arguments = Bundle().apply {
                    putString(CITY_DEPARTURE_KEY, cityDeparture)
                    putString(CITY_ARRIVE_KEY, cityArrive)
                    putString(DATE_KEY, date)
                }
            }
    }
}