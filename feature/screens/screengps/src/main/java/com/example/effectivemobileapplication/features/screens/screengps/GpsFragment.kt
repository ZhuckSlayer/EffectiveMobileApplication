package com.example.effectivemobileapplication.features.screens.screengps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.effectivemobileapplication.features.screens.screengps.databinding.FragmentGpsBinding
import com.github.terrakok.cicerone.Router


class GpsFragment : Fragment() {


    private var _binding: FragmentGpsBinding?=null
    private val binding:FragmentGpsBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=FragmentGpsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGps.setOnClickListener {

        }
    }

    companion object {
        fun newInstance() =
            GpsFragment().apply {

            }
    }
}