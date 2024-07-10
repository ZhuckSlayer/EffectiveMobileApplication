package com.example.effectivemobileapplication.features.tickets.searchtickets.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.effectivemobileapplication.features.tickets.searchtickets.ui.SearchTicketsFragment
import dagger.Subcomponent

@Subcomponent
interface SearchTicketsComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():SearchTicketsComponent
    }

    fun inject(fragment:SearchTicketsFragment)


}

interface SearchTicketsProvider{
    fun provideSearchTicketsComponent():SearchTicketsComponent
}