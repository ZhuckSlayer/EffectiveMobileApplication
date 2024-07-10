package com.example.effectivemobileapplication.ticketsDto

import com.google.gson.annotations.SerializedName

data class TicketsResponseDto(
    @SerializedName("tickets")
    val ticketsResponse: List<TicketsDto>
)
