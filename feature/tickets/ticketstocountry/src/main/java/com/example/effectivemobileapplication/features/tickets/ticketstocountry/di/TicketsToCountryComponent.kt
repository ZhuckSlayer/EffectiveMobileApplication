package com.example.effectivemobileapplication.features.tickets.ticketstocountry.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.ui.TicketsCountryFragment
import dagger.Subcomponent

@Subcomponent
interface TicketsToCountryComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():TicketsToCountryComponent
    }

    fun inject(fragment:TicketsCountryFragment)


}

interface TicketsToCountryProvider{
    fun provideTicketsToCountryComponent():TicketsToCountryComponent
}