package com.example.effectivemobileapplication.di

import com.example.effectivemobileapplication.features.tickets.musicaltickets.di.MusicalTicketsComponent
import com.example.effectivemobileapplication.features.tickets.searchtickets.di.SearchTicketsComponent
import com.example.effectivemobileapplication.features.tickets.showtickets.di.ShowTicketsComponent
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.di.TicketsToCountryComponent
import dagger.Module

@Module(
    subcomponents = [
        MusicalTicketsComponent::class,
        ShowTicketsComponent::class,
        SearchTicketsComponent::class,
        TicketsToCountryComponent::class,
        MainActivityComponent::class
    ]
)
interface SubComponentModule