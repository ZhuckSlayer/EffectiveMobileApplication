package com.example.effectivemobileapplication.shared.tickets.core.data.maper

import android.util.Log
import com.example.effectivemobileapplication.offersDto.ResponseOfferDto
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.offers.Offer
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.ticketoffers.TicketOffer
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.Arrival
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.Departure
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.HandLuggage
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.Luggage
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.Price
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.TicketInfo
import com.example.effectivemobileapplication.ticketsDto.ArrivalDto
import com.example.effectivemobileapplication.ticketsDto.DepartureDto
import com.example.effectivemobileapplication.ticketsDto.HandLuggageDto
import com.example.effectivemobileapplication.ticketsDto.LuggageDto
import com.example.effectivemobileapplication.ticketsDto.PriceDto
import com.example.effectivemobileapplication.ticketsDto.TicketsResponseDto
import com.example.effectivemobileapplication.ticketsOffersDto.TicketsOfferResponseDto
import javax.inject.Inject

class TicketsMapper @Inject constructor() {

    fun mapTicketOfferResponseToTicketOffer(
        ticketsOfferResponseDto: TicketsOfferResponseDto
    ): List<TicketOffer> {

        val result = mutableListOf<TicketOffer>()

        val ticketOffers = ticketsOfferResponseDto.ticketsOffers

        for (ticketOffer in ticketOffers) {
            val ticketOfferInfo = TicketOffer(
                id = ticketOffer.id,
                title = ticketOffer.title,
                price = mapPriceDtoToPrice(ticketOffer.priceDto),
                timeRange = ticketOffer.timeRange
            )
            result.add(ticketOfferInfo)
        }
        return result
    }

    fun mapOfferResponseToOffer(responseOfferDto: ResponseOfferDto): List<Offer> {

        val result = mutableListOf<Offer>()

        val offers = responseOfferDto.offers

        for (offer in offers) {
            val offerInfo = Offer(
                id = offer.id,
                title = offer.title,
                town = offer.town,
                price = mapPriceDtoToPrice(offer.price)
            )
            result.add(offerInfo)
        }
        return result
    }

    fun mapResponseToTicketInfo(ticketsResponseDto: TicketsResponseDto): List<TicketInfo> {
        val result = mutableListOf<TicketInfo>()
        val tickets = ticketsResponseDto.ticketsResponse

        for (ticket in tickets) {
            val ticketInfo = TicketInfo(
                id = ticket.id,
                badge = ticket.badge,
                price = mapPriceDtoToPrice(ticket.price),
                providerName = ticket.providerName,
                company = ticket.company,
                departure = mapDepartureDtoToDeparture(ticket.departure),
                arrival = mapArrivalDtoToArrival(ticket.arrival),
                transfer = ticket.transfer,
                visaTransfer = ticket.visaTransfer,
                returnable = ticket.returnable,
                exchangable = ticket.exchangable
            )
            result.add(ticketInfo)
        }
        return result
    }

    fun mapPriceDtoToPrice(price: PriceDto): Price {
        return Price(value = price.value)
    }

    fun mapDepartureDtoToDeparture(departureDto: DepartureDto): Departure {
        return Departure(
            town = departureDto.town,
            date = departureDto.date,
            airportName = departureDto.airportName
        )
    }

    fun mapArrivalDtoToArrival(arrivalDto: ArrivalDto): Arrival {
        return Arrival(
            town = arrivalDto.town,
            date = arrivalDto.date,
            airportName = arrivalDto.airportName
        )
    }
}