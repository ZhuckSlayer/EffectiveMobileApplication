package com.example.effectivemobileapplication.ticketsOffersDto

import com.example.effectivemobileapplication.ticketsDto.PriceDto
import com.google.gson.annotations.SerializedName

data class TicketOfferDto(
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("price")
    val priceDto: PriceDto,
    @SerializedName("time_range")
    val timeRange:List<String>
)
