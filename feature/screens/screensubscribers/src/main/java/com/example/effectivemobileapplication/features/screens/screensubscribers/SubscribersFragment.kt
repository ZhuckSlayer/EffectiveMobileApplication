package com.example.effectivemobileapplication.features.screens.screensubscribers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.terrakok.cicerone.Router


class SubscribersFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_subscribers, container, false)
    }

    companion object {

        fun newInstance() =
            SubscribersFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}