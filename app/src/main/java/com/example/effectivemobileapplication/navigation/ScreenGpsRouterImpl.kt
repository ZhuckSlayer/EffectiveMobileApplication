package com.example.effectivemobileapplication.navigation

import com.example.effectivemobileapplication.features.screens.screengps.ScreenGpsRouter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ScreenGpsRouterImpl @Inject constructor(
    private val router: Router
) : ScreenGpsRouter {
    override fun exit() {
        router.exit()
    }
}