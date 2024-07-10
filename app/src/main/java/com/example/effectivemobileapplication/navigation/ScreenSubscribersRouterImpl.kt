package com.example.effectivemobileapplication.navigation

import com.example.effectivemobileapplication.features.screens.screensubscribers.ScreenSubscribersRouter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ScreenSubscribersRouterImpl @Inject constructor(
    private val router: Router
) : ScreenSubscribersRouter {
    override fun exit() {
        router.exit()
    }
}