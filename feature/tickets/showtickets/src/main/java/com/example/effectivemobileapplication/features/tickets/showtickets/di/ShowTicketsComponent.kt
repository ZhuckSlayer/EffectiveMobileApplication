package com.example.effectivemobileapplication.features.tickets.showtickets.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.effectivemobileapplication.features.tickets.showtickets.ui.AllTicketsFragment
import dagger.Subcomponent

@Subcomponent
interface ShowTicketsComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():ShowTicketsComponent
    }

    fun inject(fragment:AllTicketsFragment)


}

interface ShowTicketsProvider{
    fun provideShowTicketsComponent():ShowTicketsComponent
}