package com.example.effectivemobileapplication.features.tickets.ticketstocountry.presentation

interface TicketsOfferRouter {

    fun exit()
    fun showAllTickets(cityDeparture: String,cityArrive:String,date:String)
}