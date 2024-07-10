package com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets

data class TicketInfo(
    val id:Int,
    val badge:String?,
    val price: Price,
    val providerName:String,
    val company:String,
    val departure: Departure,
    val arrival: Arrival,
    val transfer:Boolean,
    val visaTransfer:Boolean,
    val returnable:Boolean,
    val exchangable:Boolean
)
