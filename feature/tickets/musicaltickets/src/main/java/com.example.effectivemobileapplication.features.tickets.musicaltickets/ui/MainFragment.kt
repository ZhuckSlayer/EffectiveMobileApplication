package com.example.effectivemobileapplication.features.tickets.musicaltickets.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.effectivemobileapplication.features.tickets.musicaltickets.R
import com.example.effectivemobileapplication.features.tickets.musicaltickets.adapter.MusicalTicketsRecyclerView
import com.example.effectivemobileapplication.features.tickets.musicaltickets.databinding.MainFragmentBinding
import com.example.effectivemobileapplication.features.tickets.musicaltickets.di.MusicalTicketsProvider
import com.example.effectivemobileapplication.features.tickets.musicaltickets.presentation.MainViewModel
import com.example.effectivemobileapplication.features.tickets.searchtickets.ui.SearchTicketsFragment
import com.example.effectivemobileapplication.shared.tickets.core.ViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.transition.MaterialFadeThrough
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding
        get() = _binding ?: throw RuntimeException("binding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onAttach(context: Context) {
        (requireActivity().application as MusicalTicketsProvider)
            .provideMusicalTicketsComponent()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MusicalTicketsRecyclerView()
        val viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        binding.rvExamples.adapter = adapter
        lifecycleScope.launch {
            viewModel.ticketsInfo.collect {
                adapter.submitList(it)
            }
        }
        binding.arrive.setOnClickListener {
            if (binding.departure.text.isNotEmpty())
                showBottomSheet(binding.departure.text.toString())
            else
                Toast.makeText(requireContext(), "Заполните город отпралвения", Toast.LENGTH_SHORT)
                    .show()
        }

        binding.departure.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().matches("[a-zA-Z0-9]".toRegex())){
                    Toast.makeText(requireContext(),"Только русские буквы",Toast.LENGTH_SHORT)
                        .show()
                    binding.departure.text?.clear()

                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun showBottomSheet(cityDeparture: String) {

        val bundle = Bundle()
        bundle.putString(SearchTicketsFragment.CITY_NAME, cityDeparture)
        val searchTicketsFragment = SearchTicketsFragment()
        searchTicketsFragment.arguments = bundle
        searchTicketsFragment.show(childFragmentManager, SearchTicketsFragment().tag)
    }
}