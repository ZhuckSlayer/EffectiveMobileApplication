package com.example.effectivemobileapplication.features.screens.screenprofile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.effectivemobileapplication.features.screens.screenprofile.databinding.FragmentProfileScreenBinding
import com.example.effectivemobileapplication.shared.tickets.core.MainMenuRouter
import com.github.terrakok.cicerone.Router


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileScreenBinding? = null
    private val binding: FragmentProfileScreenBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonProfile.setOnClickListener {
            Router().backTo(null)
        }
    }

    companion object {

        fun newInstance() =
            ProfileFragment()
    }
}