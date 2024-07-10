package com.example.effectivemobileapplication.features.tickets.ticketstocountry

import com.example.effectivemobileapplication.features.tickets.ticketstocountry.ui.TicketsCountryFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getTicketsScreen(cityDeparture: String,cityArrive:String): FragmentScreen =
    FragmentScreen { TicketsCountryFragment.newInstance(cityDeparture,cityArrive) }