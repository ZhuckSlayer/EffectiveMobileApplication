package com.example.effectivemobileapplication.features.tickets.showtickets

import com.example.effectivemobileapplication.features.tickets.showtickets.ui.AllTicketsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun allTicketsScreen(cityDeparture: String,cityArrive:String,date:String): FragmentScreen =
    FragmentScreen { AllTicketsFragment.newInstance(cityDeparture,cityArrive,date) }