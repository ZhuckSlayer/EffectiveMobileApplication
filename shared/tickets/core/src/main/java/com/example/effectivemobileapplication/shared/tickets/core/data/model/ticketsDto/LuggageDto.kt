package com.example.effectivemobileapplication.ticketsDto

import com.google.gson.annotations.SerializedName

data class LuggageDto(
    @SerializedName("has_luggage")
    val luggage:Boolean,
    @SerializedName("price")
    val price: PriceDto
)
