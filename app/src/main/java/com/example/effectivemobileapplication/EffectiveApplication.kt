package com.example.effectivemobileapplication

import android.app.Application
import com.example.effectivemobileapplication.di.ApplicationComponent
import com.example.effectivemobileapplication.di.DaggerApplicationComponent
import com.example.effectivemobileapplication.di.MainActivityComponent
import com.example.effectivemobileapplication.di.MainActivityComponentProvider
import com.example.effectivemobileapplication.features.tickets.musicaltickets.di.MusicalTicketsComponent
import com.example.effectivemobileapplication.features.tickets.musicaltickets.di.MusicalTicketsProvider
import com.example.effectivemobileapplication.features.tickets.searchtickets.di.SearchTicketsComponent
import com.example.effectivemobileapplication.features.tickets.searchtickets.di.SearchTicketsProvider
import com.example.effectivemobileapplication.features.tickets.showtickets.di.ShowTicketsComponent
import com.example.effectivemobileapplication.features.tickets.showtickets.di.ShowTicketsProvider
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.di.TicketsToCountryComponent
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.di.TicketsToCountryProvider


class EffectiveApplication : Application(), MusicalTicketsProvider, SearchTicketsProvider,
    TicketsToCountryProvider, ShowTicketsProvider, MainActivityComponentProvider {


    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().build()
    }

    override fun provideMusicalTicketsComponent(): MusicalTicketsComponent =
        appComponent.musicalTicketsComponent().create()


    override fun provideSearchTicketsComponent(): SearchTicketsComponent =
        appComponent.searchTicketsComponent().create()

    override fun provideTicketsToCountryComponent(): TicketsToCountryComponent =
        appComponent.ticketsToCountry().create()

    override fun provideShowTicketsComponent(): ShowTicketsComponent =
        appComponent.showTicketsComponent().create()

    override fun providerMainActivityComponent(): MainActivityComponent =
        appComponent.mainActivityComponent().create()

}