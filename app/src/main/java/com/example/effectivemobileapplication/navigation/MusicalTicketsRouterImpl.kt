package com.example.effectivemobileapplication.navigation

import com.example.effectivemobileapplication.features.tickets.musicaltickets.presentation.MusicalTicketsRouter
import com.example.effectivemobileapplication.features.tickets.searchtickets.searchTicketsScreen
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MusicalTicketsRouterImpl @Inject constructor(
    private val router: Router
) : MusicalTicketsRouter {
    override fun openHotels() {
    }

    override fun openGps() {
    }

    override fun openSubscribers() {
        TODO("Not yet implemented")
    }

    override fun openProfile() {
        TODO("Not yet implemented")
    }

    override fun openSearchTickets(cityName:String) {
        router.navigateTo(searchTicketsScreen(cityName))
    }
}