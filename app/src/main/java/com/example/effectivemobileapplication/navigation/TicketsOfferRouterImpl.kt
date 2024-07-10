package com.example.effectivemobileapplication.navigation

import com.example.effectivemobileapplication.features.tickets.showtickets.allTicketsScreen
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.presentation.TicketsOfferRouter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class TicketsOfferRouterImpl @Inject constructor(
    private val router: Router
) : TicketsOfferRouter {
    override fun exit() {
        router.exit()
    }

    override fun showAllTickets(cityDeparture: String,cityArrive:String,date:String) {
       router.navigateTo(allTicketsScreen(cityDeparture, cityArrive, date))
    }
}