package com.example.effectivemobileapplication.features.screens.screenhotels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.effectivemobileapplication.features.screens.screenhotels.databinding.FragmentHotelsBinding
import com.github.terrakok.cicerone.Router


class HotelsFragment : Fragment() {

    private var _binding: FragmentHotelsBinding?=null
    private val binding:FragmentHotelsBinding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHotelsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonHotels.setOnClickListener {

        }
    }

    companion object {

        fun newInstance() =
            HotelsFragment()
    }
}