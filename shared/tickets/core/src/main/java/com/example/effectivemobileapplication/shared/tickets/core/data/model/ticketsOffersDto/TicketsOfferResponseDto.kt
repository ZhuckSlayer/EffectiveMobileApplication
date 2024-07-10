package com.example.effectivemobileapplication.ticketsOffersDto

import com.google.gson.annotations.SerializedName

data class TicketsOfferResponseDto(
    @SerializedName("tickets_offers")
    val ticketsOffers:List<TicketOfferDto>
)
