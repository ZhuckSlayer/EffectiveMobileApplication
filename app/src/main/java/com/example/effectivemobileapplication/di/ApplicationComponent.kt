package com.example.effectivemobileapplication.di

import com.example.effectivemobileapplication.features.tickets.musicaltickets.di.MusicalTicketsComponent
import com.example.effectivemobileapplication.features.tickets.searchtickets.di.SearchTicketsComponent
import com.example.effectivemobileapplication.features.tickets.showtickets.di.ShowTicketsComponent
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.di.TicketsToCountryComponent
import com.example.effectivemobileapplication.shared.tickets.core.di.DataModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigationModule::class, DataModule::class,
        ViewModelModule::class, SubComponentModule::class
    ]
)
interface ApplicationComponent {

    fun musicalTicketsComponent(): MusicalTicketsComponent.Factory
    fun searchTicketsComponent(): SearchTicketsComponent.Factory
    fun showTicketsComponent(): ShowTicketsComponent.Factory
    fun ticketsToCountry(): TicketsToCountryComponent.Factory
    fun mainActivityComponent(): MainActivityComponent.Factory
}