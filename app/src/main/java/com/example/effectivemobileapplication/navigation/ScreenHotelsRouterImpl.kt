package com.example.effectivemobileapplication.navigation

import com.example.effectivemobileapplication.features.screens.screenhotels.ScreenHotelsRouter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ScreenHotelsRouterImpl@Inject constructor(
    private val router: Router
) : ScreenHotelsRouter {
    override fun exit() {
        router.exit()
    }
}