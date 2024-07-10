package com.example.effectivemobileapplication.navigation

import com.example.effectivemobileapplication.features.tickets.showtickets.presentation.TicketsRouter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class TicketsRouterImpl @Inject constructor(
    private val router: Router
) : TicketsRouter {
    override fun exit() {
        router.exit()
    }
}