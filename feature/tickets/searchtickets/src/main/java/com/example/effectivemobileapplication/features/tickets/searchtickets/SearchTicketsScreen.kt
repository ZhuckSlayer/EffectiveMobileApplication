package com.example.effectivemobileapplication.features.tickets.searchtickets

import com.example.effectivemobileapplication.features.tickets.searchtickets.ui.SearchTicketsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun searchTicketsScreen(cityName: String): FragmentScreen =
    FragmentScreen { SearchTicketsFragment.newInstance(cityName) }