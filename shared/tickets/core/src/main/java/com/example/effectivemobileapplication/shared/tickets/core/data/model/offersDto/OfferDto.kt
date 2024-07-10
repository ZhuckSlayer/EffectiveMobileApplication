package com.example.effectivemobileapplication.offersDto

import com.example.effectivemobileapplication.ticketsDto.PriceDto
import com.google.gson.annotations.SerializedName

data class OfferDto(
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("town")
    val town:String,
    @SerializedName("price")
    val price:PriceDto
)
