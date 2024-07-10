package com.example.effectivemobileapplication.shared.tickets.core.data.repository

import com.example.effectivemobileapplication.shared.tickets.core.data.maper.TicketsMapper
import com.example.effectivemobileapplication.shared.tickets.core.data.network.ApiService
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.offers.Offer
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.ticketoffers.TicketOffer
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.TicketInfo
import com.example.effectivemobileapplication.shared.tickets.core.domain.repository.TicketsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class TicketsRepositoryImpl @Inject constructor(

    private val apiService: ApiService,
    private val mapper: TicketsMapper
) : TicketsRepository {

    private val _ticketInfo= mutableListOf<TicketInfo>()
    val ticketInfo:List<TicketInfo>
        get() = _ticketInfo.toList()
    private val scope = CoroutineScope(Dispatchers.Main)

    private val loadedTicketsFlow= flow {
        val response=apiService.getTickets()
        val ticketInfo=mapper.mapResponseToTicketInfo(response)
        _ticketInfo.addAll(ticketInfo)
        emit(ticketInfo)
    }

    private val _ticketOffer= mutableListOf<TicketOffer>()
    val ticketOffer:List<TicketOffer>
        get() = _ticketOffer.toList()

    private val loadedTicketsOfferFlow= flow {
        val response=apiService.getTicketsOffers()
        val ticketOffer=mapper.mapTicketOfferResponseToTicketOffer(response)
        _ticketOffer.addAll(ticketOffer)
        emit(ticketOffer)
    }

    private val _offerInfo= mutableListOf<Offer>()
    val offerInfo:List<Offer>
        get() = _offerInfo.toList()

    private val loadedOffersFlow= flow {
        val response=apiService.getOffers()
        val offersInfo=mapper.mapOfferResponseToOffer(response)
        _offerInfo.addAll(offersInfo)
        emit(offersInfo)
    }



    override fun showAllTickets(): StateFlow<List<TicketInfo>> =loadedTicketsFlow.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = ticketInfo
    )

    override fun getOffers(): StateFlow<List<Offer>> =loadedOffersFlow.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = offerInfo
    )

    override fun getTicketOffers(): StateFlow<List<TicketOffer>> =loadedTicketsOfferFlow.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = ticketOffer
    )
}