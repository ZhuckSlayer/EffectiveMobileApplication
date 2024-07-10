package com.example.effectivemobileapplication.features.tickets.musicaltickets

import com.example.effectivemobileapplication.features.tickets.musicaltickets.ui.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getFragmentScreen(): FragmentScreen = FragmentScreen { MainFragment() }