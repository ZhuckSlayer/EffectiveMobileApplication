package com.example.effectivemobileapplication.navigation

import com.example.effectivemobileapplication.features.screens.screenprofile.ScreenProfileRouter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ScreenProfileRouterImpl @Inject constructor(
    private val router: Router
) : ScreenProfileRouter {
    override fun exit() {
        router.exit()
    }
}