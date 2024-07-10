package com.example.effectivemobileapplication.shared.tickets.core.data.network

import com.example.effectivemobileapplication.offersDto.ResponseOfferDto
import com.example.effectivemobileapplication.ticketsDto.TicketsResponseDto
import com.example.effectivemobileapplication.ticketsOffersDto.TicketsOfferResponseDto
import retrofit2.http.GET

interface ApiService {

    @GET("uc?id=1HogOsz4hWkRwco4kud3isZHFQLUAwNBA")
    suspend fun getTickets(): TicketsResponseDto

    @GET("uc?id=13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta")
    suspend fun getTicketsOffers():TicketsOfferResponseDto

    @GET("uc?id=1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav")
    suspend fun getOffers():ResponseOfferDto

}