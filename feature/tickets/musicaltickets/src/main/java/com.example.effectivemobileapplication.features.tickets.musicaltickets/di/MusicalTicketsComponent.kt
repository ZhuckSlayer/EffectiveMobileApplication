package com.example.effectivemobileapplication.features.tickets.musicaltickets.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.effectivemobileapplication.features.tickets.musicaltickets.presentation.MainViewModel
import com.example.effectivemobileapplication.features.tickets.musicaltickets.ui.MainFragment
import dagger.Subcomponent

@Subcomponent
interface MusicalTicketsComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():MusicalTicketsComponent
    }

    fun inject(fragment:MainFragment)
    fun inject(viewModel:MainViewModel)


}

interface MusicalTicketsProvider{
    fun provideMusicalTicketsComponent():MusicalTicketsComponent
}