package com.example.effectivemobileapplication.shared.tickets.core.domain.repository

import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.offers.Offer
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.ticketoffers.TicketOffer
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.TicketInfo
import kotlinx.coroutines.flow.StateFlow
import java.util.concurrent.Flow

interface TicketsRepository {

    fun showAllTickets(): StateFlow<List<TicketInfo>>

    fun getOffers():StateFlow<List<Offer>>

    fun getTicketOffers():StateFlow<List<TicketOffer>>
}