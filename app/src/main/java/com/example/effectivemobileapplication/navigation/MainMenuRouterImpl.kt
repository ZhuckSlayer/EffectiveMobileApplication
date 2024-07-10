package com.example.effectivemobileapplication.navigation

import com.example.effectivemobileapplication.features.screens.screengps.getGpsScreen
import com.example.effectivemobileapplication.features.screens.screensubscribers.getSubscribersScreen
import com.example.effectivemobileapplication.features.tickets.musicaltickets.getFragmentScreen
import com.example.effectivemobileapplication.shared.tickets.core.MainMenuRouter
import com.github.terrakok.cicerone.Router
import com.example.effectivemobileapplication.features.screens.screenhotels.getHotelsScreen
import com.example.effectivemobileapplication.features.screens.screenprofile.getProfileScreen
import javax.inject.Inject

class MainMenuRouterImpl @Inject constructor(
    private val router: Router
) : MainMenuRouter {
    override fun openHotels() {
        router.navigateTo(getHotelsScreen())
    }

    override fun openGps() {
        router.navigateTo(getGpsScreen())
    }

    override fun openSubscribers() {
        router.navigateTo(getSubscribersScreen())
    }

    override fun openProfile() {
        router.navigateTo(getProfileScreen())
    }

    override fun openTickets() {
        router.navigateTo(getFragmentScreen())
    }

    override fun close() {
        router.exit()
    }
}