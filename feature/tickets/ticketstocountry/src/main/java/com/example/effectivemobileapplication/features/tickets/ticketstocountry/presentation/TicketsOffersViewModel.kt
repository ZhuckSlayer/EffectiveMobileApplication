package com.example.effectivemobileapplication.features.tickets.ticketstocountry.presentation

import androidx.lifecycle.ViewModel
import com.example.effectivemobileapplication.shared.tickets.core.domain.usecases.GetTicketOffersUseCase
import javax.inject.Inject

class TicketsOffersViewModel @Inject constructor(
    private val getTicketOffersUseCase: GetTicketOffersUseCase,
    private val router: TicketsOfferRouter
):ViewModel() {

    val tickets=getTicketOffersUseCase()

    fun exit(){
        router.exit()
    }

    fun navigateToAllTickets(cityDeparture: String,cityArrive:String,date:String){
        router.showAllTickets(cityDeparture, cityArrive, date)
    }




}