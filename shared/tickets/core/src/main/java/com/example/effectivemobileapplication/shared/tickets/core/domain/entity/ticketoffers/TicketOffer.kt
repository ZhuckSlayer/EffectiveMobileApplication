package com.example.effectivemobileapplication.shared.tickets.core.domain.entity.ticketoffers

import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.Price

data class TicketOffer(
    val id:Int,
    val title:String,
    val price: Price,
    val timeRange:List<String>
)
