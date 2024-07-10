package com.example.effectivemobileapplication.di

import com.example.effectivemobileapplication.features.screens.screengps.ScreenGpsRouter
import com.example.effectivemobileapplication.features.screens.screenhotels.ScreenHotelsRouter
import com.example.effectivemobileapplication.features.screens.screenprofile.ScreenProfileRouter
import com.example.effectivemobileapplication.features.screens.screensubscribers.ScreenSubscribersRouter
import com.example.effectivemobileapplication.features.tickets.musicaltickets.presentation.MusicalTicketsRouter
import com.example.effectivemobileapplication.features.tickets.searchtickets.presentation.SearchTicketsRouter
import com.example.effectivemobileapplication.features.tickets.showtickets.presentation.TicketsRouter
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.presentation.TicketsOfferRouter
import com.example.effectivemobileapplication.navigation.MainMenuRouterImpl
import com.example.effectivemobileapplication.navigation.MusicalTicketsRouterImpl
import com.example.effectivemobileapplication.navigation.ScreenGpsRouterImpl
import com.example.effectivemobileapplication.navigation.ScreenHotelsRouterImpl
import com.example.effectivemobileapplication.navigation.ScreenProfileRouterImpl
import com.example.effectivemobileapplication.navigation.ScreenSubscribersRouterImpl
import com.example.effectivemobileapplication.navigation.SearchTicketsRouterImpl
import com.example.effectivemobileapplication.navigation.TicketsOfferRouterImpl
import com.example.effectivemobileapplication.navigation.TicketsRouterImpl
import com.example.effectivemobileapplication.shared.tickets.core.MainMenuRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        BindViewModelRouter::class
    ]
)
class NavigationModule {

    @Singleton
    private val cicerone = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(): Router = cicerone.router

    @Provides
    @Singleton
    fun provideNavigationHolder(): NavigatorHolder = cicerone.getNavigatorHolder()
}

@Module
interface BindViewModelRouter {
    @Binds
    fun provideContactsRouter(impl: MusicalTicketsRouterImpl): MusicalTicketsRouter
    @Binds
    fun provideSearchRouter(impl:SearchTicketsRouterImpl):SearchTicketsRouter
    @Binds
    fun provideTicketsOfferRouter(impl: TicketsOfferRouterImpl):TicketsOfferRouter

    @Binds
    fun provideTicketsInfoRouter(impl: TicketsRouterImpl):TicketsRouter

    @Binds
    fun provideMainMenuRouter(impl:MainMenuRouterImpl):MainMenuRouter

    @Binds
    fun provideSubscribersRouter(impl:ScreenSubscribersRouterImpl): ScreenSubscribersRouter

    @Binds
    fun provideProfileRouter(impl:ScreenProfileRouterImpl): ScreenProfileRouter

    @Binds
    fun provideGpsRouter(impl:ScreenGpsRouterImpl): ScreenGpsRouter

    @Binds
    fun provideHotelsRouter(impl:ScreenHotelsRouterImpl): ScreenHotelsRouter





}