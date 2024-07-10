package com.example.effectivemobileapplication.di

import androidx.lifecycle.ViewModel
import com.example.effectivemobileapplication.features.tickets.musicaltickets.presentation.MainViewModel
import com.example.effectivemobileapplication.features.tickets.searchtickets.presentation.SearchTicketsViewModel
import com.example.effectivemobileapplication.features.tickets.showtickets.presentation.TicketsViewModel
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.presentation.TicketsOffersViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(TicketsOffersViewModel::class)
    fun bindTicketsOfferViewModel(viewModel: TicketsOffersViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SearchTicketsViewModel::class)
    fun bindSearchTicketsViewModel(viewModel: SearchTicketsViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(TicketsViewModel::class)
    fun bindAllTicketsViewModel(viewModel: TicketsViewModel): ViewModel



}