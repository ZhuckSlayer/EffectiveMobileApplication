package com.example.effectivemobileapplication.features.tickets.musicaltickets.presentation

import androidx.lifecycle.ViewModel
import com.example.effectivemobileapplication.shared.tickets.core.domain.usecases.GetAllTicketsInfoUseCase
import com.example.effectivemobileapplication.shared.tickets.core.domain.usecases.GetOffersInfoUseCase
import com.example.effectivemobileapplication.shared.tickets.core.domain.usecases.GetTicketOffersUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: MusicalTicketsRouter,
    private val getOffersUseCase: GetOffersInfoUseCase
):ViewModel() {

    val ticketsInfo=getOffersUseCase()

    fun navigateToSearchTickets(cityName:String){
        router.openSearchTickets(cityName)
    }

}