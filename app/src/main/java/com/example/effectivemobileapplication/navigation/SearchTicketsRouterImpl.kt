package com.example.effectivemobileapplication.navigation

import com.example.effectivemobileapplication.features.tickets.anywheretickets.getAnywhereTicketsScreen
import com.example.effectivemobileapplication.features.tickets.firetickets.getFireTicketsScreen
import com.example.effectivemobileapplication.features.tickets.searchtickets.presentation.SearchTicketsRouter
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.getTicketsScreen
import com.example.effectivemobileapplication.features.tickets.weekends.getWeekendsScreen
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SearchTicketsRouterImpl @Inject constructor(
    private val router: Router
):SearchTicketsRouter {
    override fun openHardRoute() {
        router.navigateTo(getAnywhereTicketsScreen())
    }

    override fun openCalendar() {
        router.navigateTo(getWeekendsScreen())
    }

    override fun openFreeTickets() {
        router.navigateTo(getFireTicketsScreen())
    }

    override fun openTicketsToCountry(cityName: String) {

    }

    override fun openTicketsOffers(cityDeparture: String, cityArrive: String) {
        router.navigateTo(getTicketsScreen(cityDeparture,cityArrive))
    }

}